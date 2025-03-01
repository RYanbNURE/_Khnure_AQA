'use strict';

module.exports = {
    extends: 'lighthouse:default',
    settings: {
        maxWaitForLoad: 35 * 1000,
        emulatedFormFactor: 'mobile',
        scores: {
            'performance': 90,
            'accessibility': 90,
            'best-practices': 90,
            'seo': 80
        },
        onlyCategories: [
            'performance',
            'accessibility',
            'best-practices',
            'seo'
        ]
    },
};
