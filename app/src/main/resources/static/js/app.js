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
        	templateUrl: 'partials/crud/save.html',
        	controller:	'user',
        },

        '/vehicle/model': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'model',
        },
        '/vehicle/model/:id/update': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'model',
        },
        '/vehicle/model/create': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'model',
        },
        
        '/vehicle/type': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'type',
        },
        '/vehicle/type/:id/update': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'type',
        },
        '/vehicle/type/create': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'type',
        },

        '/vehicle': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'vehicle',
        },
        '/vehicle/:id/update': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'vehicle',
        },
        '/vehicle/create': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'vehicle',
        },
        
        '/rental/point': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'rentalPoint',
        },
        '/rental/point/:id/update': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'rentalPoint',
        },
        '/rental/point/create': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'rentalPoint',
        },
        '/rental/point': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'rentalPoint',
        },
        
        '/customer': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'customer',
        },        
        '/customer/:id/update': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'customer',
        },
        '/customer/create': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'customer',
        },

        '/rental': {
        	templateUrl: 'partials/crud/list.html',
        	controller:	'rental',
        },        
        '/rental/:id/update': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'rental',
        },
        '/rental/create': {
        	templateUrl: 'partials/crud/save.html',
        	controller:	'rental',
        }
};

var CarRental = angular.module('CarRental', [
	  'ngRoute',
	  'datatables',
	  'CarRental.controllers',
	  'CarRental.services',
	  'ui.bootstrap'
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