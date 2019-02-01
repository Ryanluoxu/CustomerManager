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
	}).when('/orderInfo', {
		templateUrl : 'pages/orderInfo.html',
		controller : 'orderInfoController'
	}).when('/orderInfo/add', {
		templateUrl : 'pages/orderInfo/add.html',
		controller : 'orderInfoController'
	})

	.otherwise({
		redirectTo : '/'
	});

});

