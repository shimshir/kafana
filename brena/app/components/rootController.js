app.controller('rootController', function ($scope, USER_ROLES, AuthService) {
	$scope.currentUser = null;
	$scope.userRoles = USER_ROLES;
	$scope.isAuthorized = AuthService.isAuthorized;
	$scope.isAuthenticated = AuthService.isAuthenticated;

	$scope.setCurrentUser = function (user) {
		$scope.currentUser = user;
	};
});
