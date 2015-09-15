app.controller('studentListController', ['$scope', 'Api',
	function ($scope, Api) {
		$scope.students = Api.Student.query();
	}
]);
