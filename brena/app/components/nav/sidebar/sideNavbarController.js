app.controller('sideNavbarController', ['$scope', '$location', 'Api',
	function ($scope, $location, Api) {

		$scope.isActive = function (viewLocation) {
			return $location.path().startsWith(viewLocation);
		};

		$scope.showSidebar = function () {
			return $location.path() != "/";
		};

		$scope.sidebar = Api.Sidebar.get({path: $location.path().substring(1)});
	}
]);
