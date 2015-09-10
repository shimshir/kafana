app.config(function($routeProvider) {
	$routeProvider.when("/",
		{
			templateUrl: "components/home/homeView.html",
			controller: "homeController"
		}
	).when("/students",
		{
			templateUrl: "components/student/studentListView.html",
			controller: "studentListController"
		}
	);
});
