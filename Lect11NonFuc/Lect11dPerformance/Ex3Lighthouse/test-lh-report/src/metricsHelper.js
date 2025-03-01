const elh = require('./expectedValues');
const reportHelper = require('./reportHelper');

module.exports = {
    formatMessage(auditsMap, metricType, pageSlug) {
        const page = pageSlug === "" ? `store` : pageSlug;
        let message = `egs-lhr-audits,pageSlug=${page},type=${metricType} `;

        auditsMap.forEach((value, key, map) => {
            if (!key.includes('Formatted')) {
                message = `${message}${key}=${value},`
            }
        });
        // console.log(message.substr(0, message.length - 1));
        return message.substr(0, message.length - 1);
    },

    // scrape data from a Lighthouse audit for asserting against
    getBooleanMetricValue(lhr, metricName) {
        const score = new Map()
            .set(0, 'Fail')
            .set(1, 'Pass')
            .set(null, 'Pass');
        
        return score.get(lhr.audits[metricName].score);
    },

    getResourceMetrics(lhr) {
        const metrics = new Map();
        lhr.audits['resource-summary'].details.items.forEach(item => {
            metrics.set(`${item.resourceType}RequestCount`, item.requestCount);
            metrics.set(`${item.resourceType}Size`, item.size);
        });
        return metrics;
    },

    getTimingMetrics(lhr) {
        const metrics = new Map();
        Object.keys(elh.timingsMetrics).forEach(metric => {
            metrics.set(metric, this.getTimingMetricValue(lhr, metric));
        });
        return metrics;
    },

    getTimingMetricValue(lhr, metricName) {
        return Math.round(lhr.audits[metricName].numericValue / 1000);
    },

    getAudits(lhr) {
        const metrics = new Map();
        Object.keys(elh.auditScoreThresholds).forEach(metric => {
            metrics.set(metric, this.getAuditValue(lhr, metric));
        });
        return metrics;
    },

    getAuditValue(lhr, metricName) {
        return lhr.categories[metricName].score * 100;
    },

    percentile(arr, p) {
        if (arr.length === 0) return 0;
        if (typeof p !== 'number') throw new TypeError('p must be a number');
        if (p <= 0) return arr[0];
        if (p >= 1) return arr[arr.length - 1];

        arr.sort(function (a, b) {
            return a - b;
        });
        var index = (arr.length - 1) * p
        const lower = Math.floor(index),
            upper = lower + 1,
            weight = index % 1;

        if (upper >= arr.length) return arr[lower];
        return arr[lower] * (1 - weight) + arr[upper] * weight;
    },

    getImagesList(lhr) {
        const imageList = lhr.audits['network-requests'].details
            .items
            .filter(item => item.resourceType === 'Image');
        imageList.sort((a, b) => {
            return b.transferSize - a.transferSize;
        });

        return imageList;
    },

    calculateImagesSize(imageList) {
        return imageList
            .reduce((accumulator, currentValue) => accumulator + currentValue);
    },

    getImageRequestsMetrics(lhr) {
        const imageList = this.getImagesList(lhr).map(image => image.transferSize);
        const metrics = new Map()
        const percentiles = [0.8, 0.75, 0.5, 0.25];
        percentiles.forEach(p => {
            metrics.set(`p${p*100}`, this.percentile(imageList, p));
            metrics.set(`p${p*100}Formatted`, reportHelper.formatBytes(this.percentile(imageList, p)));
        });
        
        const imagesAboveP80 = imageList.filter(item => item >= this.percentile(imageList, 0.8));
        metrics.set(`imageMaxSize`, Math.max(...imageList));
        metrics.set(`imageMaxSizeFormatted`, reportHelper.formatBytes(Math.max(...imageList)));
        metrics.set(`imagesTop20PercentsSize`, this.calculateImagesSize(imagesAboveP80));
        metrics.set(`imagesTop20PercentsSizeFormatted`, reportHelper.formatBytes(this.calculateImagesSize(imagesAboveP80)));
        metrics.set(`imagesTop20PercentsCount`, imagesAboveP80.length);
        metrics.set(`imagesTop20PercentsSizePercentage`, Math.round(this.calculateImagesSize(imagesAboveP80) / this.calculateImagesSize(imageList) * 100));
        metrics.set(`imagesTotalCount`, imageList.length);
        metrics.set(`imagesTotalSize`, this.calculateImagesSize(imageList));
        metrics.set(`imagesTotalSizeFormatted`, reportHelper.formatBytes(this.calculateImagesSize(imageList)));
      
        return metrics;
    }

}
