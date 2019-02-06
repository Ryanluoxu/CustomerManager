/**
 *
 */
app.controller('companyInfoController', function($scope, $http, $rootScope, $location) {
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
	$scope.addCompanyInfo = function(companyInfo) {
		var input = {
				"companyName":$scope.companyInfo.companyName,
				"country":$scope.companyInfo.country
		}
		$http.post('/companyInfo/add', input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/companyInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.goToCompanyInfoAdd = function(){
		$location.url("/companyInfo/add");
	}
	$scope.editCompanyInfo = function(companyInfoVO) {
		$rootScope.companyInfo = companyInfoVO;
		$location.url("/companyInfo/edit");			
	}
	$scope.updateCompanyInfo = function(companyInfo) {
		var input = {
				"companyInfoId":companyInfo.companyInfoId,
				"companyName":companyInfo.companyName,
				"country":companyInfo.country
		}
		$http.post('/companyInfo/update', input).success(function(data, status, headers, config) {
			if (data.status == 'success') {
				alert("success");
				$location.url("/companyInfo");				
			} else if (data.status == 'fail') {
				alert(data.errorMsg);
			}
		}).error(function(data, status, headers, config) {
			$scope.message = "fail";
		})
	}
	$scope.deleteCompanyInfo = function(companyInfoId) {
		var isConfirmed = confirm("Are you sure to delete this record ?");
		if (isConfirmed) {
			var input = {
					"companyInfoId":companyInfoId
			}
			$http.post('/companyInfo/delete', input).success(function(data, status, headers, config) {
				if (data.status == 'success') {
					alert("success");
					$location.url("/companyInfo");				
				} else if (data.status == 'fail') {
					alert(data.errorMsg);
				}
			}).error(function(data, status, headers, config) {
				$scope.message = "fail";
			})			
		}
	}
 
	$scope.isPreview = false;
	$scope.findAllCompanyInfo();
});