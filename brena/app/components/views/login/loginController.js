app.controller('loginController', function ($scope, $rootScope, $location, AUTH_EVENTS, AuthService) {
	$scope.credentials = {
		username: '',
		password: ''
	};

	$scope.login = function (credentials) {
		AuthService.login(credentials).then(function (user) {
			$scope.setCurrentUser(user);
			$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
			if ($rootScope.loginRedirectUrl != undefined) {
				console.log($rootScope.loginRedirectUrl);
				$location.path($rootScope.loginRedirectUrl);
				$rootScope.loginRedirectUrl = undefined;
			}
			$('#loginModal').modal('hide');
		}, function (error) {
			console.log(error);
			$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
		});
	};

	$scope.$on(AUTH_EVENTS.loginSuccess, function (event) {
		console.log(event);
	});
});
