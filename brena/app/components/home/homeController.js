app.controller('homeController', function ($scope, $http) {
	$http.get(apiEndpoint + "/developers")
		.success(function (response) {
			$scope.developers = response;
		});
});