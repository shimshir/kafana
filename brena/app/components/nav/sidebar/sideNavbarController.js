app.controller('sideNavbarController', ['$scope', '$location',
	function ($scope, $location) {

		$scope.isActive = function (viewLocation) {
			return $location.path().startsWith(viewLocation);
		};

		$scope.showSidebar = function () {
			return $location.path() != "/";
		};
	}
]);
