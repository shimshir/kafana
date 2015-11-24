var app = angular.module('brena', ['ui.router', 'ngResource']);

app.run(
	function ($rootScope, $location, $state, $timeout, AUTH_EVENTS, AuthService) {
		$rootScope.$on('$stateChangeStart',
			function (event, next) {
				if (next.data != undefined && next.data.authorizedRoles != undefined) {
					var authorizedRoles = next.data.authorizedRoles;
					if (!AuthService.isAuthorized(authorizedRoles)) {
						event.preventDefault();
						if (AuthService.isAuthenticated()) {
							// user is not allowed
							$rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
							console.log(AUTH_EVENTS.notAuthorized)
						} else {
							// user is not logged in
							$rootScope.$broadcast(AUTH_EVENTS.notAuthenticated, {currentState: $state.current, nextState: next});
							console.log(AUTH_EVENTS.notAuthenticated)
							if ($rootScope.loginModalControllerInitialized !== true) {
								$rootScope.loginRedirectUrl = $location.path();
								$timeout(function() {
									$location.path('/login');
								});
							}
						}
					}
				}
			}
		);
	}
);
