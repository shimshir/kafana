var http = require('http'),
	httpProxy = require('http-proxy');

var proxy = httpProxy.createProxyServer({});

var proxyServer = http.createServer(function(req, res) {
	req.url = "/index.html";
	proxy.web(req, res, { target: 'http://localhost:8000' });
});

console.log("Proxy Server listening on 5050");

proxyServer.listen(5050);
