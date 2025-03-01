const auditScoreThresholds = {
    accessibility: 70,
    performance: 20,
    'best-practices': 85,
    seo: 90
}

const booleanMetrics = {
    // 'uses-http2': 'Pass',
    'hreflang': 'Pass',
    'robots-txt': 'Pass',
    'is-crawlable': 'Pass',
   // 'no-vulnerable-libraries': 'Pass',
    'errors-in-console': 'Pass'
};

const timingsMetrics = {
    'first-contentful-paint': 3,
    'first-meaningful-paint': 10,
    'speed-index': 15,
    'estimated-input-latency': 2,
    'total-blocking-time': 20,
    'first-cpu-idle': 15,
    'interactive': 20
    // 'bootup-time': 10

};

module.exports = {
    auditScoreThresholds,
    booleanMetrics,
    timingsMetrics
};

