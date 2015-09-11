app.controller('sideNavbarController', ['$scope', '$location',
	function ($scope, $location) {

		$scope.isActive = function (viewLocation) {
			return $location.path().startsWith(viewLocation);
		};

		$scope.showSidebar = function () {
			return $location.path() != "/";
		};

		$scope.sidebarLinks = [
			{
				name: "Students",
				url: "/academic/students",
				links: []
			},
			{
				name: "Courses",
				url: "/academic/courses",
				links: [
					{
						name: "Math",
						url: "/academic/courses/math",
						links: []
					}
				]
			}
		]
	}
]);
