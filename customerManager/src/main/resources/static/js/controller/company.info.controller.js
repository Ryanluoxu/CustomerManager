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

	$scope.isPreview = false;
	$scope.findAllCompanyInfo();
});