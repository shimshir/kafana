var brenaServices = angular.module('brenaServices', ['ngResource']);

brenaServices.factory('Api', ['$resource',
	function ($resource) {
		var apiEndpoint = 'http://localhost:5000/halid/api/v1';
		return {
			Student: $resource(apiEndpoint + '/students/:id'),
			Sidebar: $resource(apiEndpoint+ '/sidebar/:path')
		};
	}
]);
