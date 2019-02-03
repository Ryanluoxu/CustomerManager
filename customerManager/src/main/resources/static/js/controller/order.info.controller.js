/**
 *
 */
app.controller('orderInfoController', function($scope, $http, $rootScope, $location) {
	$scope.findAllOrderInfo = function() {
		$http.get("/orderInfo/findAll").success(function(data, status, headers, config) {
			$scope.orderInfoVOs = data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.findAllCustomerInfo = function() {
		$http.get("/customerInfo/findAll").success(function(data, status, headers, config) {
			$scope.customerInfoVOs = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.addOrderInfo = function(orderInfo) {
		var orderInfoInput = {
				"customerInfoId":$scope.orderInfo.customerInfoId,
				"productName":$scope.orderInfo.productName,
				"paymentMode":$scope.orderInfo.paymentMode,
				"unitPrice":$scope.orderInfo.unitPrice,
				"quantity":$scope.orderInfo.quantity,
				"profit":$scope.orderInfo.profit
		}
		$http.post('/orderInfo/add', orderInfoInput).success(function(data, status, headers, config) {
			$scope.message = "Success";
			$location.url("/orderInfo"); 
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}

	$scope.goToOrderInfoAdd = function(){
		$location.url("/orderInfo/add");
	}

	$scope.findAllOrderInfo();
	$scope.findAllCustomerInfo();
});