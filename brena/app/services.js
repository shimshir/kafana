app.factory('Api', function ($resource, APP_CONSTANTS) {
		return {
			Student: $resource(APP_CONSTANTS.apiEndpoint + '/students/:id'),
			Sidebar: $resource(APP_CONSTANTS.apiEndpoint + '/sidebar/:path')
		};
	}
).factory('AuthService', function ($http, Session, APP_CONSTANTS) {
	var authService = {};

	authService.login = function (credentials) {
		return $http.post(APP_CONSTANTS.apiEndpoint + '/login', credentials)
					.then(function (res) {
						var userSession = res.data;
						Session.create(userSession.id, userSession.user.id, userSession.user.account.roles);
						return userSession.user;
					});
				};

	authService.isAuthenticated = function () {
		return !!Session.userId;
	};

	authService.isAuthorized = function (authorizedRoles) {
		if (!angular.isArray(authorizedRoles)) {
			authorizedRoles = [authorizedRoles];
		}
		return (authService.isAuthenticated() && authorizedRoles.indexOf(Session.userRole) !== -1);
	};

	return authService;
	}
).service('Session', function () {
		this.create = function (sessionId, userId, userRoles) {
			this.id = sessionId;
			this.userId = userId;
			this.userRoles = userRoles;
		};
		this.destroy = function () {
			this.id = null;
			this.userId = null;
			this.userRoles = null;
		};
	}
);
