app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise(function($injector, $location){
		var state = $injector.get('$state');
		state.go('404');
		return $location.path();
	});

	$stateProvider
		.state('main', {
			url: '/',
			templateUrl: 'components/views/main/mainView.html'
		})
		.state('home', {
			url: '/home',
			templateUrl: 'components/views/home/homeView.html'
		})
		.state('academic', {
			url: '/academic',
			templateUrl: 'components/views/academic/academicView.html'
		})
		.state('social', {
			url: '/social',
			templateUrl: 'components/views/social/socialView.html'
		})
		.state('login', {
			url: '/login',
			templateUrl: 'components/views/login/loginView.html'
		})
		.state('academic.students', {
			url: '/academic/students',
			templateUrl: 'components/views/academic/student/studentListView.html'
		})
		.state('404', {
			templateUrl: 'shared/404.html'
		});
});
