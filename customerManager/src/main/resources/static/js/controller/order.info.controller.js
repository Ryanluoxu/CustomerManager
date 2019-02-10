/**
 *
 */
app.controller('orderInfoController', function($scope, $http, $rootScope, $location) {
	$scope.findAllOrderInfo = function() {
		$http.get("/orderInfo/findAll").success(function(data, status, headers, config) {
			$scope.orderInfoVOs = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.findOrderInfoByCustomerInfoId = function(customerInfoId) {
		var input = {
				"customerInfoId":customerInfoId,
		}
		$http.post("/orderInfo/findByCustomerInfoId", input).success(function(data, status, headers, config) {
			$scope.orderInfoVOs = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.findAllProductInfo = function() {
		$http.get("/productInfo/findAll").success(function(data, status, headers, config) {
			$scope.productInfoVOs = data.data;
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
	$scope.preview = function(){
		$scope.isPreview = true;
	}
	$scope.addOrderInfo = function(orderInfo) {
		var input = {
				"customerInfoId":orderInfo.customerInfo.customerInfoId,
				"productInfoId":orderInfo.productInfo.productInfoId,
				"paymentMode":orderInfo.paymentMode,
				"unitPrice":orderInfo.unitPrice,
				"quantity":orderInfo.quantity,
				"profit":orderInfo.profit
		}
		$http.post('/orderInfo/add', input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/orderInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.goToOrderInfoAdd = function(){
		$location.url("/orderInfo/add");
	}
	$scope.editOrderInfo = function(orderInfo) {
		$rootScope.orderInfo = orderInfo;
		$location.url("/orderInfo/edit");			
	}
	$scope.updateOrderInfo = function(orderInfo) {
		var input = {
				"orderInfoId":orderInfo.orderInfoId,
				"customerInfoId":orderInfo.customerInfo.customerInfoId,
				"productInfoId":orderInfo.productInfo.productInfoId,
				"paymentMode":orderInfo.paymentMode,
				"unitPrice":orderInfo.unitPrice,
				"quantity":orderInfo.quantity,
				"profit":orderInfo.profit
		}
		$http.post('/orderInfo/update', input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/orderInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.deleteOrderInfo = function(orderInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"orderInfoId":orderInfoId
			}
			$http.post('/orderInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$location.url("/orderInfo");				
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})			
		}
	}
 
	$scope.isPreview = false;
	if ($rootScope.seletedCustomerInfo) {
		$scope.findOrderInfoByCustomerInfoId($rootScope.seletedCustomerInfo.customerInfoId);
		$rootScope.seletedCustomerInfo = null;
	} else {
		$scope.findAllOrderInfo();
	}
	$scope.findAllProductInfo();
	$scope.findAllCustomerInfo();
});