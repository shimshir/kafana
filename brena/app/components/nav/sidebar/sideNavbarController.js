app.controller('sideNavbarController', ['$scope', '$location', 'Api',
	function ($scope, $location, Api) {
		$scope.hasSidebar = function () {
			return angular.isDefined($scope.sidebar.path);
		};

		$scope.isActive = function (viewLocation) {
			return $location.path().startsWith(viewLocation);
		};

		$scope.sidebar = Api.Sidebar.get({path: $location.path().replace(/\//g,'~')});

		$scope.$on('$locationChangeSuccess', function() {
			Api.Sidebar.get({path: $location.path().replace(/\//g,'~')},
				function (response) {
					if (response.path != $scope.sidebar.path)
						$scope.sidebar = response;
				}
			);
		});
	}
]);
