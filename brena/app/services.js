app.factory('Api', function ($resource, APP_CONSTANTS) {
		return {
			Student: $resource(APP_CONSTANTS.apiEndpoint + '/students/:id'),
			Sidebar: $resource(APP_CONSTANTS.apiEndpoint + '/sidebar/:path')
		};
	}
).factory('AuthService', function ($http, Session, APP_CONSTANTS) {
		return {
			login: function (credentials) {
						return $http
							.post(APP_CONSTANTS.apiEndpoint + '/login', credentials)
							.then(function (response) {
								Session.create(response.session.id, response.session.user.id, response.session.user.role);
								return response.session.user;
							});
					},

			isAuthenticated: function () {
				return !!Session.userId;
			},

			isAuthorized: function (authorizedRoles) {
				if (!angular.isArray(authorizedRoles)) {
					authorizedRoles = [authorizedRoles];
				}
				return (authService.isAuthenticated() &&
				authorizedRoles.indexOf(Session.userRole) !== -1);
			}
		};
	}
).service('Session', function () {
		this.create = function (sessionId, userId, userRole) {
			this.id = sessionId;
			this.userId = userId;
			this.userRole = userRole;
		};
		this.destroy = function () {
			this.id = null;
			this.userId = null;
			this.userRole = null;
		};
	}
);
