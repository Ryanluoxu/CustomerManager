/**
 *
 */
app.controller('customerInfoController', function($scope, $http, $rootScope, $location) {

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
	$scope.addCustomerInfo = function(customerInfo) {
		var customerInfoInput = {
				"customerName":$scope.customerInfo.customerName,
				"function":$scope.customerInfo.function,
				"companyName":$scope.customerInfo.companyName,
				"country":$scope.customerInfo.country,
				"email":$scope.customerInfo.email,
				"contactMobile":$scope.customerInfo.contactMobile,
				"contactOffice":$scope.customerInfo.contactOffice,
				"contactFax":$scope.customerInfo.contactFax,
				"address":$scope.customerInfo.address
		}
		$http.post('/customerInfo/add', customerInfoInput).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/customerInfo");
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}

	$scope.editCustomerInfo = function(customerInfoVO) {
		$rootScope.customerInfo = customerInfoVO;
		$location.url("/customerInfo/edit");
	}

	$scope.updateCustomerInfo = function(customerInfo) {
		var input = {
				"customerInfoId":customerInfo.customerInfoId,
				"customerName":customerInfo.customerName,
				"function":customerInfo.function,
				"companyName":customerInfo.companyName,
				"country":customerInfo.country,
				"email":customerInfo.email,
				"contactMobile":customerInfo.contactMobile,
				"contactOffice":customerInfo.contactOffice,
				"contactFax":customerInfo.contactFax,
				"address":customerInfo.address
		}
		$http.post('/customerInfo/update', input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/customerInfo");
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}

	$scope.deleteCustomerInfo = function(customerInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"customerInfoId":customerInfoId
			}
			$http.post('/customerInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$location.url("/customerInfo");
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})
		}
	}

	$scope.goToCustomerInfoAdd = function(){
		$location.url("/customerInfo/add");
	}
	$scope.showOrderInfo = function(customerInfoVO){
		$rootScope.seletedCustomerInfo = customerInfoVO;
		$location.url("/orderInfo");
	}
	
	$scope.isPreview = false;
	$scope.findAllCustomerInfo();
});