app.controller('topNavbarController', ['$scope', '$location',
	function ($scope, $location) {
		$scope.isActive = function (viewLocation) {
			return $location.path().startsWith(viewLocation);
		};

		$scope.userAvatarUrl = "assets/img/user/admin/avatar/useravatar.png";
	}
]);
