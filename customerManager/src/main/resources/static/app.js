/**
 *
 */

var app = angular.module('app', [ 'ngRoute' ]);

// configure our routes
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})
	
	.when('/customerInfo', {
		templateUrl : 'pages/customerInfo/view.html',
		controller : 'customerInfoController'
	}).when('/customerInfo/addOrEdit', {
		templateUrl : 'pages/customerInfo/addOrEdit.html',
		controller : 'customerInfoController'
	})
	
	.when('/orderInfo', {
		templateUrl : 'pages/orderInfo/view.html',
		controller : 'orderInfoController'
	}).when('/orderInfo/addOrEdit', {
		templateUrl : 'pages/orderInfo/addOrEdit.html',
		controller : 'orderInfoController'
	})
	
	.when('/userInfo', {
		templateUrl : 'pages/userInfo/view.html',
		controller : 'userInfoController'
	}).when('/userInfo/addOrEdit', {
		templateUrl : 'pages/userInfo/addOrEdit.html',
		controller : 'userInfoController'
	})
	
	.when('/companyInfo', {
		templateUrl : 'pages/companyInfo/view.html',
		controller : 'companyInfoController'
	}).when('/companyInfo/addOrEdit', {
		templateUrl : 'pages/companyInfo/addOrEdit.html',
		controller : 'companyInfoController'
	})
	
	.when('/productInfo', {
		templateUrl : 'pages/productInfo/view.html',
		controller : 'productInfoController'
	}).when('/productInfo/addOrEdit', {
		templateUrl : 'pages/productInfo/addOrEdit.html',
		controller : 'productInfoController'
	})
	
	.otherwise({
		redirectTo : '/'
	});

});

