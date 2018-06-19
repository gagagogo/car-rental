'use strict';
window.routes =
{
		'/index': {
        	templateUrl: 'partials/system/index.html',
        	controller:	'index',
        },
        '/user': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'user',
        },
        '/user/:id/update': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'user',
        },
        '/user/create': {
        	templateUrl: 'partials/system/userForm.html',
        	controller:	'user',
        }
};

var CarRental = angular.module('CarRental', [
	  'ngRoute',
	  'datatables',
	  'CarRental.controllers'
	])
  .config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');
      
      for(var path in window.routes) {
          $routeProvider.when(path, window.routes[path]);
      }
      
      $routeProvider.otherwise('/index');
    }
  ]);