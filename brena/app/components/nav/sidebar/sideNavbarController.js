app.controller('sideNavbarController', ['$scope', '$location', 'Api',
	function ($scope, $location, Api) {

		$scope.isActive = function (viewLocation) {
			return $location.path().startsWith(viewLocation);
		};

		$scope.sidebar = Api.Sidebar.get({path: $location.path().replace(/\//g,'_')});

		$scope.$on('$locationChangeStart', function() {
			Api.Sidebar.get({path: $location.path().replace(/\//g,'_')},
				function (response) {
					if (response.path != $scope.sidebar.path)
						$scope.sidebar = response;
				}
			);
		});
	}
]);
