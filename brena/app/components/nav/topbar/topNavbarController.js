app.controller('topNavbarController', ['$scope', '$location',
	function ($scope, $location) {
		$scope.isActive = function (viewLocation) {
			return $location.path().startsWith(viewLocation);
		};
	}
]);
