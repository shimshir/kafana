var brenaServices = angular.module('brenaServices', ['ngResource']);

brenaServices.factory('Student', ['$resource',
	function($resource) {
		return $resource('http://localhost:8080/halid/api/v1/students/:studentId', {}, {
		  query: {method:'GET', params:{studentId:''}, isArray:true}
		});
	}
]);
