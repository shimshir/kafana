app.controller('homeController', ['$scope', 'Developer',
	function ($scope, Developer) {
		$scope.developers = Developer.query();
	}
]);
