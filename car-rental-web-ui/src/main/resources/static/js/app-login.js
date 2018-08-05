'use strict';
var CarRental = angular.module('CarRentalLogin', ['spring-security-csrf-token-interceptor'])
.controller('LoginCtrl',['$http','$scope','$location',function($http,$scope,$location){
	
	$scope.username;
	$scope.pass;
	
	$scope.loginProcessingUrl = "/system/authenticate";
	
	$scope.messages = [];
	
	$scope.login = function(){
	
    	var data = 'username='+$scope.username+'&password='+$scope.pass;
    	
    	
    	$http({
    		'method':"POST"
    		,'url':$scope.loginProcessingUrl
    		,'headers': {
                "Content-Type": "application/x-www-form-urlencoded",
                "X-Login-Ajax-call": 'true'
    		}
    		,'data':data
    	})
    	.then(function successCallback(response) {
    		
    		if(response.status==200) window.location.replace("/");
    		else{
    			$scope.messages = [];
	        	$scope.messages.push(response.data.message);
    		} 
    		
    	  }, function errorCallback(response) {
    		  	$scope.messages = [];
    	        $scope.messages.push("Some thing wrong with request");

    	  });

    }
	
}]);