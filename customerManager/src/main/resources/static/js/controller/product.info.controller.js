/**
 *
 */
app.controller('productInfoController', function($scope, $http, $rootScope, $location) {
	$scope.findAllProductInfo = function() {
		$http.get("/productInfo/findAll").success(function(data, status, headers, config) {
			$scope.productInfoVOs = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.findAllCompanyInfo = function() {
		$http.get("/companyInfo/findAll").success(function(data, status, headers, config) {
			$scope.companyInfoVOs = data.data;
		}).error(function(data, status, headers, config) {
			$scope.message = status;
		})
	}
	$scope.preview = function(){
		$scope.isPreview = true;
	}
	$scope.addProductInfo = function(productInfo) {
		var input = {
				"productName":productInfo.productName,
				"companyInfoId":productInfo.companyInfo.companyInfoId
		}
		$http.post('/productInfo/add', input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/productInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.goToProductInfoAdd = function(){
		$location.url("/productInfo/add");
	}
	$scope.editProductInfo = function(productInfoVO) {
		$rootScope.productInfo = productInfoVO;
		$location.url("/productInfo/edit");			
	}
	$scope.updateProductInfo = function(productInfo) {
		var input = {
				"productInfoId":productInfo.productInfoId,
				"productName":productInfo.productName,
				"companyInfoId":productInfo.companyInfo.companyInfoId
		}
		$http.post('/productInfo/update', input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/productInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.deleteProductInfo = function(productInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"productInfoId":productInfoId
			}
			$http.post('/productInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$location.url("/productInfo");				
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})			
		}
	}
 
	$scope.isPreview = false;
	$scope.findAllProductInfo();
	$scope.findAllCompanyInfo();
});