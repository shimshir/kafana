app.controller('loginController', function ($scope, $rootScope, AUTH_EVENTS, AuthService) {
	$scope.credentials = {
		username: '',
		password: ''
	};

	$scope.login = function (credentials, sourcePath) {
		AuthService.login(credentials).then(function (user) {
			$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
			$scope.setCurrentUser(user);
		}, function () {
			$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
		});
	};

	$scope.$on(AUTH_EVENTS.loginSuccess, function (event) {
		console.log(event);
	});
});
