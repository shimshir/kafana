app.config(function($routeProvider) {
	$routeProvider.when("/",
		{
			templateUrl: "components/views/main/mainView.html"
		}
	).when("/home",
		{
			templateUrl: "components/views/home/homeView.html"
		}
	).when("/academic",
		{
			templateUrl: "components/views/academic/academicView.html"
		}
	).when("/social",
		{
			templateUrl: "components/views/social/socialView.html"
		}
	).when("/academic/students",
		{
			templateUrl: "components/views/academic/student/studentListView.html"
		}
	).otherwise(
		{
			templateUrl: "shared/error.html"
		});
	}
);
