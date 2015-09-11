app.config(function($routeProvider) {
	$routeProvider.when("/",
		{
			templateUrl: "components/home/homeView.html",
		}
	).when("/academic",
		{
			templateUrl: "components/academic/academicView.html",
		}
	).when("/social",
		{
			templateUrl: "components/social/socialView.html",
		}
	).when("/academic/students",
		{
			templateUrl: "components/academic/student/studentListView.html",
		}
	).otherwise(
		{
			templateUrl: "shared/error.html"
		});
	}
);
