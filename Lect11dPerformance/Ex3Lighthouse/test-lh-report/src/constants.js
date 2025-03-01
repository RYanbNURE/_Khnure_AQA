const argv = require('minimist')(process.argv.slice(2));

const baseUrl = 'https://www.epicgames.com/store';
const slugs = argv.url || ['/', '/browse', '/product/fortnite/home', '/product/borderlands-3/home'];

const reportDir = 'reports';

module.exports = {
    baseUrl,
    slugs,
    reportDir
};
