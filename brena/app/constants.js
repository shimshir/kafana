app.constant('AUTH_EVENTS', {
	loginSuccess: 'auth-login-success',
	loginFailed: 'auth-login-failed',
	logoutSuccess: 'auth-logout-success',
	sessionTimeout: 'auth-session-timeout',
	notAuthenticated: 'auth-not-authenticated',
	notAuthorized: 'auth-not-authorized'
}).constant('USER_ROLES', {
	student: 'STUDENT',
	admin: 'ADMIN',
	staff: 'STAFF',
	guest: 'GUEST'
}).constant('APP_CONSTANTS', {
	apiEndpoint: 'http://localhost:5000/halid/api/v1'
});
