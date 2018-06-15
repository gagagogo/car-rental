'use strict';
window.routes =
{
		'/login':{
        	templateUrl: 'partials/system/login.html',
        	controller:	'login'
		},
		'/index': {
        	templateUrl: 'partials/system/index.html',
        	controller:	'index',
        	requireLogin: true
        },
        '/user': {
        	templateUrl: 'partials/system/user.html',
        	controller:	'user',
        	requireLogin: true
        },
        '/user/create': {
        	templateUrl: 'partials/system/userForm.html',
        	controller:	'user',
        	requireLogin: true
        }
};

var CarRental = angular.module('CarRental', [
	  'ngRoute',
	  'datatables',
	  'CarRental.controllers',
	  'CarRental.services'
	])
  .config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');
      
      for(var path in window.routes) {
          $routeProvider.when(path, window.routes[path]);
      }
      
      $routeProvider.otherwise('/index');
    }
  ])
  .run(function($rootScope,SessionService,$location){

    $rootScope.$on("$routeChangeStart", function(event, next, current) {
    	if(next.requireLogin && !SessionService.getUserAuthenticated()) {
    		$location.path( "/login");
            event.preventDefault();
    	}
    });

});