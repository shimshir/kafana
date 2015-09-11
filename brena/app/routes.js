app.config(function($routeProvider) {
	$routeProvider.when("/",
		{
			templateUrl: "components/home/homeView.html",
		}
	).when("/students",
		{
			templateUrl: "components/student/studentListView.html",
		}
	).otherwise(
		{
			templateUrl: "shared/error.html"
		});
});
