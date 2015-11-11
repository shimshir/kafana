app.constant('AUTH_EVENTS', {
	loginSuccess: 'auth-login-success',
	loginFailed: 'auth-login-failed',
	logoutSuccess: 'auth-logout-success',
	sessionTimeout: 'auth-session-timeout',
	notAuthenticated: 'auth-not-authenticated',
	notAuthorized: 'auth-not-authorized'
}).constant('USER_ROLES', {
	all: 'student',
	admin: 'admin',
	staff: 'staff',
	guest: 'guest'
}).constant('APP_CONSTANTS', {
	apiEndpoint: 'http://localhost:5000/halid/api/v1'
});
