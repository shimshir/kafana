app.controller('loginModalController', function ($rootScope, $scope, AUTH_EVENTS) {
	$rootScope.loginModalControllerInitialized = true;
	$scope.$on(AUTH_EVENTS.notAuthenticated, function (event, data) {
		if (data.currentState.url !== '/login') {
			$('#loginModal').modal('show');
			$rootScope.loginRedirectUrl = data.nextState.url;
		}
	});
});
