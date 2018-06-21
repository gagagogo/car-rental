'use strict';

angular.module('CarRental.controllers', ['spring-security-csrf-token-interceptor'])
.controller('user',['$scope','$routeParams','$route','$http','$formUtils',function($scope,$routeParams,$route,$http,$formUtils){
	
	$scope.form_model = {
		columns:{
			'idUser':{'title':'ID','value':null}
			,'name':{'title':'Login','value':null}
			,'descr':{'title':'Full name','value':null}
			,'password':{'title':'Password','value':null}
		}
		,form_action_url:'/user/save'
		,message:""	
	};
	
	
	
	if($routeParams.id){
		$formUtils.loadModel(
			$scope.form_model
			,"/system/user/"+$routeParams.id
			,$scope.form_model.message
		);
	}else{
		delete $scope.form_model.columns['idUser'];
	}
	
	$scope.saveFormSubmit= function(){
		$formUtils.save(
			$scope.form_model
			,"/system/user/save"
			,"/user"
		);
	};

	
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
.controller('UtilCtrl',['$scope','$location','$window','$timeout','$formUtils',function($scope,$location,$window,$timeout,$formUtils){

	$scope.$location = $location;

	$scope.messages = showMessages();

	function showMessages() {
      $timeout(function () {
        	$formUtils.cleanMessages();
        }, 5000);
      return $formUtils.getMessages();
    }

}])
.controller('index',['$scope',function($scope){}]);