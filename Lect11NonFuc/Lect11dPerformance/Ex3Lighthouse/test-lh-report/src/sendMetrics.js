const net = require('net');
const fs = require('fs');
const path = require('path');
const helper = require('./metricsHelper');

const host = 'telegraf.ol.epicgames.net';
const port = '8094';
import {
    slugs,
    reportDir
} from './constants';

function sendMetricsToInfluxDb(auditsMap, metricType, suffix) {
    const message = helper.formatMessage(auditsMap, metricType, suffix);
    console.log(message);
    const client = net.createConnection(port, host, () => {
        console.log(`Connected to ${  host}`);
        client.write(message, () => {
            console.log('Data is sent to server');
        });
        client.end();
    });

    client.on('data', (data) => {
        console.log(`Received: ${  data.toString()}`);
    });

    client.on('end', () => {
        console.log('Connection closed');
    });

    client.on('error', (error) => {
        console.log('Error occurred!');
        console.log(error);
    });
};

for (const slug of slugs) {
    let suffix = slug.split('/').join('_')

    const lhr = fs.readFileSync(path.join(reportDir, `reportdesktop${  suffix}.json`));
    const lhrJson = JSON.parse(lhr);
    const auditsScores = helper.getAudits(lhrJson);
    const timingMetrics = helper.getTimingMetrics(lhrJson);
    const resourceMetrics = helper.getResourceMetrics(lhrJson);
    const imagesMetrics = helper.getImageRequestsMetrics(lhrJson);

    suffix = slug.split('/').join('')
    sendMetricsToInfluxDb(auditsScores, 'auditscores', suffix);
    sendMetricsToInfluxDb(timingMetrics, 'timings', suffix);
    sendMetricsToInfluxDb(resourceMetrics, 'resources', suffix);
    sendMetricsToInfluxDb(imagesMetrics, 'images', suffix);
}

