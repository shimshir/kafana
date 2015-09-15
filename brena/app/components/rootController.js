app.controller('rootController', ['$scope', '$location',
	function ($scope, $location) {

		$scope.showSidebar = function () {
			return $location.path() != "/";
		};
	}
]);
