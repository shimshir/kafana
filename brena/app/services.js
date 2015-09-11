var brenaServices = angular.module('brenaServices', ['ngResource']);

brenaServices.factory('Student', ['$resource',
	function($resource) {
		return $resource('http://localhost:5000/halid/api/v1/students/:studentId', {}, {
		  query: {method:'GET', params:{studentId:''}, isArray:true}
		});
	}
]);
