'use strict';
angular.module('CarRental', [
	  'CarRental.services',
	  'CarRental.controllers',
	  'ngRoute'
	])
  .config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
        when('/login', {
        	templateUrl: 'partials/system/login.html',
        	controller:	'/login'
        }).
        when('/index', {
        	templateUrl: 'partials/system/index.html',
        	controller:	'/index'
        }).        
        otherwise('/index');
    }
  ]);