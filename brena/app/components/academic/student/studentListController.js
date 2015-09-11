app.controller('studentListController', ['$scope', 'Student',
	function ($scope, Student) {
		$scope.students = Student.query();
	}
]);
