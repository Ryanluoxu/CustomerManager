/**
 *
 */

app.controller('mainController', function($scope, $http, $location, $rootScope) {

	$scope.goHome = function() {
		$location.url("/")
	}
	$scope.login = function() {
		$location.url("/login")
	}
	$scope.showUserPage = function() {
		$location.url("/user")
	}
	$scope.showAdminPage = function() {
		$location.url("/admin")
	}
	
	
});