'use strict';
angular.module('CarRental.services', [])
.service('SessionService', ['$http',function($http){
	
	var loginProcessingUrl = "/authenticate";
	
    var userIsAuthenticated = false;

    this.setUserAuthenticated = function(value){
        userIsAuthenticated = value;
    };

    this.getUserAuthenticated = function(){
        return userIsAuthenticated;
    }
    
    this.login=function(login,pass){
    	$http.post(loginProcessingUrl,
    			{ 	'username':login,
    				'password':pass	
    			}
    		);
    }
}]);