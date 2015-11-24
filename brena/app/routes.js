app.config(function($stateProvider, $urlRouterProvider, USER_ROLES) {

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
		.state('academic-courses', {
			url: '/academic/courses',
			templateUrl: 'components/views/academic/course/courseListView.html'
		})
		.state('academic-exams', {
			url: '/academic/exams',
			templateUrl: 'shared/404.html'
		})
		.state('academic-staffs', {
			url: '/academic/staffs',
			templateUrl: 'shared/404.html'
		})
		.state('academic-students', {
			url: '/academic/students',
			templateUrl: 'components/views/academic/student/studentListView.html',
			data: {
				authorizedRoles: [USER_ROLES.student]
			}
		})
		.state('academic-groups', {
			url: '/academic/groups',
			templateUrl: 'shared/404.html'
		})
		.state('404', {
			templateUrl: 'shared/404.html'
		});
});
