/**
 *
 */

app.controller('adminController', function($scope, $http, $location, $rootScope) {

	$scope.showUserInfo = function() {
		$location.url("/userInfo")
	}
	$scope.goHome = function() {
		$location.url("/")
	}

});