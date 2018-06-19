'use strict';

angular.module('CarRental.controllers', ['spring-security-csrf-token-interceptor'])
.controller('user',['$scope','$routeParams','$route','$http',function($scope,$routeParams,$route,$http){
	
	$scope.form_model = {
		columns:{
					'idUser':{'title':'ID','value':null}
					,'name':{'title':'Login','value':null}
					,'descr':{'title':'Full name','value':null}
					,'pass':{'title':'Password','value':null}
			}
		,form_action_url:'/user/save'	
	};
	
	$scope.saveFormSubmit= function(){};

	
	$scope.vm=
		{dtOptions:{
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'system/user/list',
    			'dataSrc':"data"
    			}
    	}
    	,dtColumns:[
    		{'data':'idUser','title':'ID',
    			render: function ( data, type, row ) {return '<a href="#!/user/'+data+'/update">'+data+"</a>"}
    		}
    		,{'data':'name','title':'Login'}
    		,{'data':'descr','title':'Descr'}
	        ]
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
	
    $scope.logout=function () {
        $http({
            method: 'POST',
            url: '/logout'
        })
        .then(function (response) {
            if (response.status == 200) {
            	window.location.reload();
            }
            else {
            }
        });
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