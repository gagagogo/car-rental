'use strict';

angular.module('CarRental.controllers', ['spring-security-csrf-token-interceptor'])
.controller('user',['$scope','$routeParams','$route','$http','$formUtils',function($scope,$routeParams,$route,$http,$formUtils){
	
	$scope.title="User";
	
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
.controller('model',['$scope','$routeParams','$location','$http','$formUtils','$compile',function($scope,$routeParams,$location,$http,$formUtils,$compile){
	
	$scope.title="Vehicle model";
	
	$scope.form_model = {
		columns:{
			'idVehicleModel':{'title':'ID','value':null}
			,'descr':{'title':'Full name','value':null}
		}
		,form_action_url:'/vehicle/model/save'
		,message:""	
	};
	
	
	
	if($routeParams.id){
		$formUtils.loadModel(
			$scope.form_model
			,"/vehicle/model/"+$routeParams.id
			,$scope.form_model.message
		);
	}else{
		delete $scope.form_model.columns['idVehicleModel'];
	}
	
	$scope.saveFormSubmit= function(){
		$formUtils.save(
			$scope.form_model
			,"/vehicle/model/save"
			,"/vehicle/model"
		);
	};

	
	$scope.vm=
		{dtOptions:{
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'vehicle/model/list',
    			'dataSrc':"data"
    		},
			'createdRow':function(row){
		        $compile(angular.element(row).contents())($scope);
			}

    	}
    	,dtColumns:[
    		{'data':'idVehicleModel','title':'ID',
    			render: function ( data, type, row ) {return '<a ng-click="onRowClick('+data+')">'+data+"</a>"}
    		}
    		,{'data':'descr','title':'Descr'}
	        ]
		};
	
	$scope.onRowClick = function(data){
		var edata = {
			entity_id:data,
			handeled:false
		};
		
		$scope.$emit('eventModelSelected', edata); // идем наверх!
		
		if(!edata.handeled) $location.path('/vehicle/model/'+data+'/update')
	};
	
}])
.controller('type',['$scope','$routeParams','$route','$http','$formUtils',function($scope,$routeParams,$route,$http,$formUtils){
	
	$scope.title="Vehicle type";
	
	$scope.form_model = {
		columns:{
			'idVehicleType':{'title':'ID','value':null}
			,'descr':{'title':'Full name','value':null}
		}
		,form_action_url:'/vehicle/type/save'
		,message:""	
	};
	
	
	
	if($routeParams.id){
		$formUtils.loadModel(
			$scope.form_model
			,"/vehicle/type/"+$routeParams.id
			,$scope.form_model.message
		);
	}else{
		delete $scope.form_model.columns['idVehicleType'];
	}
	
	$scope.saveFormSubmit= function(){
		$formUtils.save(
			$scope.form_model
			,"/vehicle/type/save"
			,"/vehicle/type"
		);
	};

	
	$scope.vm=
		{dtOptions:{
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'vehicle/type/list',
    			'dataSrc':"data"
    		}
    	}
    	,dtColumns:[
    		{'data':'idVehicleType','title':'ID',
    			render: function ( data, type, row ) {return '<a href="#!/vehicle/type/'+data+'/update">'+data+"</a>"}
    		}
    		,{'data':'descr','title':'Descr'}
	        ]
		};
	
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
.controller('vehicle',['$scope','$routeParams','$route','$http','$formUtils',function($scope,$routeParams,$route,$http,$formUtils){
	
	$scope.title="Vehicle";
	
	$scope.form_model = {
		columns:{
			'idVehicle':{'title':'ID','value':null}
			,'regNum':{'title':'Reg num','value':null}
			,'lastRental':{'title':'Last rental','value':null}			
			,'rentalPoint':{'title':'rentalPoint','value':null}	
			,'vehicleModel':{'title':'Vehicle model','value':null,'modelUrl':"vehicle/model/",'listUrl':"vehicle/model/list"}
		}
		,form_action_url:'/vehicle/save'
		,message:""	
	};
	
	
	
	if($routeParams.id){
		$formUtils.loadModel(
			$scope.form_model
			,"/vehicle/"+$routeParams.id
			,$scope.form_model.message
		);
	}else{
		delete $scope.form_model.columns['idVehicle'];
	}
	
	$scope.saveFormSubmit= function(){
		$formUtils.save(
			$scope.form_model
			,"/vehicle/save"
			,"/vehicle"
		);
	};

	
	$scope.vm=
		{dtOptions:{
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'vehicle/list',
    			'dataSrc':"data"
    		}
    	}
    	,dtColumns:[
    		{'data':'idVehicle','title':'ID',
    			render: function ( data, type, row ) {return '<a href="#!/vehicle/'+data+'/update">'+data+"</a>"}
    		}
    		,{'data':'regNum','title':'Reg num'}
    		,{'data':'vehicleType.descr','title':'Vehicle type'}
    		,{'data':'vehicleModel.descr','title':'Model'}
	        ]
		};
	
	$scope.selectEntity=function(ctrl,$event,loadTo){
		var element = angular.element($event.currentTarget);
		$formUtils.selectFormOpen(ctrl,element,loadTo);
	};
	
}])
.controller('index',['$scope',function($scope){}]);