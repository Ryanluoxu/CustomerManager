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
	$scope.showCompanyInfo = function() {
		$location.url("/companyInfo")
	}
	$scope.showProductInfo = function() {
		$location.url("/productInfo")
	}
	$scope.showUserInfo = function() {
		$location.url("/userInfo")
	}
	$scope.goHome = function() {
		$location.url("/")
	}

});