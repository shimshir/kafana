app.controller('studentListController', ['$scope', 'Api',
	function ($scope, Api) {
		Api.Student.query(function (data) {
			$scope.students = data;
			for (var i = 0; i < $scope.students.length; i++) {
				$scope.students[i].account = Api.Account.get({id: $scope.students[i].accountId});
			}
		});
	}
]);
