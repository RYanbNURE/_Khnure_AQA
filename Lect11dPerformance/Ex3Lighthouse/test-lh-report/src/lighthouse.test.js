'use strict';

const fs = require('fs');
const helper = require('./metricsHelper');
const expected = require('./expectedValues');
const path = require('path');
let lhrJson;
const {slugs, reportDir} = require('./constants');


for (const slug of slugs) {
    describe(`Google Lighthouse audit tests ${  slug}`, () => {
            const suffix = slug.split('/').join('_')

            beforeAll(() => {
                const jsonReportName = path.join(reportDir, `reportdesktop${suffix}.json`);
                console.log(jsonReportName);
                lhrJson = fs.readFileSync(jsonReportName);
                lhrJson = JSON.parse(lhrJson);
            });
        

        // Object.keys(expected.auditScoreThresholds).forEach((metric) => {
        //     it(`${metric} score should be greater than ${expected.auditScoreThresholds[metric]}`, async () => {
        //         expect(helper.getAuditValue(lhrJson, metric)).toBeGreaterThanOrEqual(expected.auditScoreThresholds[metric]);
        //     });
        // });

        Object.keys(expected.booleanMetrics).forEach((metric) => {
            it(`passes ${metric} check`, async () => {
                expect(helper.getBooleanMetricValue(lhrJson, metric)).toEqual(expected.booleanMetrics[metric]);
            });
        });

        // Object.keys(expected.timingsMetrics).forEach((metric) => {
        //     it(`${metric} should be less than ${expected.timingsMetrics[metric]}s`, async () => {
        //         expect(helper.getTimingMetricValue(lhrJson, metric)).toBeLessThanOrEqual(expected.timingsMetrics[metric]);
        //     });
        // });
        
    });
}
