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
	$scope.addOrUpdateOrderInfo = function(orderInfo) {
		var input = {
				"customerInfoId":orderInfo.customerInfo.customerInfoId,
				"productInfoId":orderInfo.productInfo.productInfoId,
				"paymentMode":orderInfo.paymentMode,
				"unitPrice":orderInfo.unitPrice,
				"quantity":orderInfo.quantity,
				"profit":orderInfo.profit
		}
		var postPath = '/orderInfo/add';
		if ($rootScope.isEdit) {
			input.orderInfoId = orderInfo.orderInfoId;
			postPath = '/orderInfo/update';
		}
		$http.post(postPath, input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$scope.orderInfo = null;
				$location.url("/orderInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
				$scope.isPreview = false;
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.goToOrderInfoAdd = function(){
		$rootScope.isEdit = false;
		$location.url("/orderInfo/addOrEdit");
	}
	$scope.editOrderInfo = function(orderInfo) {
		$rootScope.orderInfo = orderInfo;
		$rootScope.isEdit = true;
		$location.url("/orderInfo/addOrEdit");			
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
					$rootScope.orderInfo = null;
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