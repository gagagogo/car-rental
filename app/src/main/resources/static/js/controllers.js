'use strict';

angular.module('CarRental.controllers', [])
.controller('login',['$scope',function($scope){}])
.controller('user',['$scope','$window','DTColumnBuilder','$http','SessionService',function($scope,$window,DTColumnBuilder,$http,SessionService){
    var vm = this;
    vm.dtOptions = {
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'system/user/list',
    			'dataSrc':"data"
    			}
    	};

    vm.dtColumns = [
        DTColumnBuilder.newColumn('idUser').withTitle('ID'),
        DTColumnBuilder.newColumn('name').withTitle('Login'),
        DTColumnBuilder.newColumn('descr').withTitle('Descr')
    ];
    
	$scope.usernew = {
			"name":"",
			"descr":"",
			"pass":""
	};
	$scope.creteUserSubmit = function(){
		$http({
			  "method"  : 'POST',
			  "url"     : '/user/create',
			  "data"    : JSON.stringify($scope.usernew) 
		})
		.success(function(data) {
			console.log(data);
		});
	};
	
	$scope.getUserAuthenticated = function(){
		return SessionService.getUserAuthenticated();
	}
	
}])
.controller('index',['$scope',function($scope){}]);
/*.controller('userCreate',['$scope','$http',function($scope,$http){
	$scope.user = {
			"name":"",
			"descr":"",
			"pass":""
	};
	$scope.title = "Create user";
	
	$scope.sbmt = function(){
		/*$http({
			  "method"  : 'POST',
			  url     : '/user/create',
			  data    : JSON.stringify($scope.user), 
			 })
			 .success(function(data) {
			    console.log(data);
			    if (!data.success) {
			      // if not successful, bind errors to error variables
			      $scope.errorName = data.errors.name;
			      $scope.errorSuperhero = data.errors.superheroAlias;
			    } else {
			      // if successful, bind success message to message
			      $scope.message = data.message;
			    }
			  });*/
/*	}

	};
}]);*/