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
		$rootScope.customerInfoVO = customerInfoVO;
		$location.url("/customerInfo/edit");			
	}
	
	$scope.updateCustomerInfo = function(customerInfo) {
		var customerInfoInput = {
				"customerInfoId":$scope.customerInfo.customerInfoId,
				"function":$scope.customerInfo.function,
				"companyName":$scope.customerInfo.companyName,
				"country":$scope.customerInfo.country,
				"email":$scope.customerInfo.email,
				"contactMobile":$scope.customerInfo.contactMobile,
				"contactOffice":$scope.customerInfo.contactOffice,
				"contactFax":$scope.customerInfo.contactFax,
				"address":$scope.customerInfo.address
		}
		$http.post('/customerInfo/update', customerInfoInput).success(function(data, status, headers, config) {
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
		var customerInfoInput = {
				"customerInfoId":customerInfoId
		}
		$http.post('/customerInfo/delete', customerInfoInput).success(function(data, status, headers, config) {
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

	$scope.goToCustomerInfoAdd = function(){
		$location.url("/customerInfo/add");
	}

	$scope.findAllCustomerInfo();
	$scope.customerInfo = $rootScope.customerInfoVO;
});