var brenaServices = angular.module('brenaServices', ['ngResource']);

brenaServices.factory('Developer', ['$resource',
	function($resource) {
		return $resource('http://localhost:8080/halid/api/v1/developers/:developerId', {}, {
		  query: {method:'GET', params:{developerId:''}, isArray:true}
		});
	}
]);
