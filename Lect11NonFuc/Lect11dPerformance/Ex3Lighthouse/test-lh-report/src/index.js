const chromeLauncher = require('chrome-launcher');
const lighthouse = require('lighthouse');
const reportGenerator = require('lighthouse/lighthouse-core/report/report-generator');
const fs = require('fs');
const path = require('path');

const configDesktop = require('./config-desktop');
const configMobile = require('./config-mobile');
const reportHelper = require('./reportHelper');
const helper = require('./metricsHelper');

import {baseUrl, slugs, reportDir} from './constants';

const opts = {
    chromeFlags: ['--headless', '--no-sandbox', '--disable-gpu', '--disable-dev-shm-usage'],
    chromePath: process.env.CHROME_BIN || process.env.CHROME_PATH,
    logLevel: 'info',
    output: 'json',
    disableDeviceEmulation: true,
    defaultViewport: {
        width: 1200,
        height: 900
    }
};

const launchChromeAndRunLighthouse = async (url, opts, reportSuffix = '', config = null) => {
    // Launch chrome using chrome-launcher
    const chrome = await chromeLauncher.launch(opts);
    opts.port = chrome.port;

    // Run Lighthouse.
    const report = await lighthouse(url, opts, config).then(results => {
        return results;
    });
    const html = reportGenerator.generateReport(report.lhr, 'html');
    const json = reportGenerator.generateReport(report.lhr, 'json');

    await chrome.kill();

    //Write report html to the file
   
    fs.writeFile(path.join(reportDir, `report${  reportSuffix  }.html`), html, (err) => {
        if (err) {
            console.error(err);
        }
    });

    //Write report json to the file
    fs.writeFile(path.join(reportDir, `report${  reportSuffix  }.json`), json, (err) => {
        if (err) {
            console.error(err);
        }
    });

    return json;
};


/**
 * 
 * @param {*} lhrJson 
 * Generates report listing top heavy images based on lh json report
 */
const generateImagesReport = (lhrJson, reportSuffix) => {
    const lhr = JSON.parse(lhrJson);
    const imageList = helper.getImagesList(lhr);

    const metrics = helper.getImageRequestsMetrics(lhr);
    let i = 1;
    const imageListForReport = imageList.map((item) => {
        const reportItem = {};
        reportItem.number = i;
        reportItem.url = item.url;
        reportItem.transferSize = reportHelper.formatBytes(item.transferSize);
        i++;
        return reportItem;
    });

    const html = reportHelper.formHtmlReport(imageListForReport, metrics);
    //Write report html to the file
    fs.writeFile(path.join(reportDir, `reportImages${  reportSuffix  }.html`), html, (err) => {
        if (err) {
            console.error(err);
        }
    });
}

const run = async () => {
    if (!fs.existsSync(`/${  reportDir}`)) {
        try {
             fs.mkdirSync(reportDir);
        } catch (error) {
            console.log(error)
        }
    }
    for (const slug of slugs) {
        const url = baseUrl + slug;
        const suffix = slug.split('/').join('_');
        
        await launchChromeAndRunLighthouse(url, opts, `mobile${  suffix}`, configMobile);
        const lhrJson = await launchChromeAndRunLighthouse(url, opts, `desktop${  suffix}`, configDesktop);
        // lhrJson = fs.readFileSync('reportdesktop.json');
        generateImagesReport(lhrJson, suffix);
    }
}

run();
