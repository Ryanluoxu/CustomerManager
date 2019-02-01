/**
 *
 */

app.controller('mainController', function($scope, $http, $location, $rootScope) {

	$scope.showCustomerInfo = function() {
		$location.url("/customerInfo")
	}

	$scope.showOrderInfo = function() {
		$location.url("/orderInfo")
	}

});