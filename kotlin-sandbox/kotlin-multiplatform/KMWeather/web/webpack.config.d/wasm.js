var CopyPlugin = require('copy-webpack-plugin');

config.plugins.push(
    new CopyPlugin({
        patterns: [
            { from: '../../node_modules/sql.js/dist/sql-wasm.wasm', to: '../../../web/build/distributions' }
        ]
    })
);