/**
 *
 */

var app = angular.module('app', [ 'ngRoute' ]);

// configure our routes
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	}).when('/customerInfo', {
		templateUrl : 'pages/customerInfo.html',
		controller : 'customerInfoController'
	}).when('/customerInfo/add', {
		templateUrl : 'pages/customerInfo/add.html',
		controller : 'customerInfoController'
	}).when('/customerInfo/edit', {
		templateUrl : 'pages/customerInfo/edit.html',
		controller : 'customerInfoController'
	})
	
	.when('/orderInfo', {
		templateUrl : 'pages/orderInfo.html',
		controller : 'orderInfoController'
	}).when('/orderInfo/add', {
		templateUrl : 'pages/orderInfo/add.html',
		controller : 'orderInfoController'
	})
	
	.when('/companyInfo', {
		templateUrl : 'pages/companyInfo.html',
		controller : 'companyInfoController'
	}).when('/companyInfo/add', {
		templateUrl : 'pages/companyInfo/add.html',
		controller : 'companyInfoController'
	}).when('/companyInfo/edit', {
		templateUrl : 'pages/companyInfo/edit.html',
		controller : 'companyInfoController'
	})
	
	.when('/productInfo', {
		templateUrl : 'pages/productInfo.html',
		controller : 'productInfoController'
	}).when('/productInfo/add', {
		templateUrl : 'pages/productInfo/add.html',
		controller : 'productInfoController'
	}).when('/productInfo/edit', {
		templateUrl : 'pages/productInfo/edit.html',
		controller : 'productInfoController'
	})

	.otherwise({
		redirectTo : '/'
	});

});

