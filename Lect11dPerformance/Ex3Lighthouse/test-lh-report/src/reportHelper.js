module.exports = {
    json2table(json, classes) {
        var cols = Object.keys(json[0]);

        var headerRow = '';
        var bodyRows = '';

        classes = classes || '';

        cols.map((col) => {
            headerRow += `<th>${  col  }</th>`;
        });

        json.map((row) => {
            bodyRows += '<tr>';

            cols.map((colName) => {
                if (colName === 'url') {
                    bodyRows += `<td><a href="${row[colName]}" target="_blank">${  row[colName]  }</a></td>`;
                    return
                }
                bodyRows += `<td>${  row[colName]  }</td>`;
            });

            bodyRows += '</tr>'
});

        return `<table class="${ 
            classes 
            }"><thead><tr>${ 
            headerRow 
            }</tr></thead><tbody>${ 
            bodyRows 
            }</tbody></table>`;
    },
       

    // https://stackoverflow.com/questions/15900485/correct-way-to-convert-size-in-bytes-to-kb-mb-gb-in-javascript
    formatBytes(bytes, decimals = 2) {
        if (bytes === 0) return '0 Bytes';

        const k = 1024;
        const dm = decimals < 0 ? 0 : decimals;
        const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

        const i = Math.floor(Math.log(bytes) / Math.log(k));

        return `${parseFloat((bytes / Math.pow(k, i)).toFixed(dm))  } ${  sizes[i]}`;
    },

    formHtmlReport(imageList, imageRequestsSummary) {
        
        const style = `<head><style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            font-size: 12px;
        }

        td, tr {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #cceeff;
            font-size: 18px;
        }

        h1 {
            font-family: arial, sans-serif;
            font-size: 14px;
        }
        h3 {
            font-family: arial, sans-serif;
            font-weight: normal;
            font-size: 12px;
        }
        </style>
        </head>`;
        return `<html>
                   ${style}
                    <body>
                        <h1>Total number of requests: ${imageRequestsSummary.get('imagesTotalCount')}. Total size: ${imageRequestsSummary.get('imagesTotalSizeFormatted')}.</h1>
                        <h3>80% of images have size equal or less than: ${imageRequestsSummary.get('p80Formatted')}.</h3>
                        <h3>Top 20% images count: ${imageRequestsSummary.get('imagesTop20PercentsCount')}.</h3> 
                        <h3>Top 20% images size: ${imageRequestsSummary.get('imagesTop20PercentsSizeFormatted')}. This is ${imageRequestsSummary.get('imagesTop20PercentsSizePercentage')}% of all images loaded upfront.</h3> 
                
                        ${this.json2table(imageList)}
                    </body>
                </html>`
    }


} 
