'use strict';
var CarRental = angular.module('CarRental', [
	  'ngRoute',
	  'datatables',
	  'CarRental.controllers',
	  'CarRental.services'
	])
  .config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/login', {
        	templateUrl: 'partials/system/login.html',
        	controller:	'login'
        }).
        when('/index', {
        	templateUrl: 'partials/system/index.html',
        	controller:	'index'
        }).        
        when('/user', {
        	templateUrl: 'partials/system/user.html',
        	controller:	'user'
        }).        
        otherwise('/index');
    }
  ]);