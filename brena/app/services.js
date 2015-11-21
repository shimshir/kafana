app.factory('Api', function ($resource, APP_CONSTANTS) {
		return {
			Student: $resource(APP_CONSTANTS.apiEndpoint + '/students/:id'),
			Sidebar: $resource(APP_CONSTANTS.apiEndpoint + '/sidebar/:path')
		};
	}
).factory('AuthService', function ($http, Session, APP_CONSTANTS) {
	var authService = {};

	authService.login = function (credentials) {
		return $http.post(APP_CONSTANTS.apiEndpoint + '/user/login', credentials)
					.then(function (res) {
						var userSession = res.data;
						Session.create(userSession.id, userSession.user.id, userSession.user.account.roles);
						return userSession.user;
					});
				};

	authService.isAuthenticated = function () {
		return !!Session.userId;
	};

	authService.isAuthorized = function (requiredRoles) {
		if (Session.userRoles === undefined)
			return false;

		if (!angular.isArray(requiredRoles))
			requiredRoles = [requiredRoles];

		var hasRequiredRoles = Session.userRoles.filter(function(userRole) {
			return requiredRoles.indexOf(userRole) > -1;
		}).length == requiredRoles.length;

		return authService.isAuthenticated() && hasRequiredRoles;
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
