'use strict';

angular.module('CarRental.controllers', ['spring-security-csrf-token-interceptor','ui.bootstrap'])
.controller('user',['$scope','$routeParams','$route','$http','$formUtils','$compile','$location',function($scope,$routeParams,$route,$http,$formUtils,$compile,$location){
	
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
		//$scope.$apply();		
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
			,'createdRow':function(row){
		        $compile(angular.element(row).attr('ng-click','onRowClick($event)'))($scope);
			}
    	}
    	,dtInstance:{}
    	,dtColumns:[
    		{'data':'idUser','title':'ID'}
    		,{'data':'name','title':'Login'}
    		,{'data':'descr','title':'Descr'}
	        ]
		};
	
	
	$scope.onRowClick = function(event){
		var row = angular.element(event.currentTarget);
		
		var data = {
			entity:$scope.vm.dtInstance.DataTable.row(row).data(),
			handeled:false
		};
		
		$scope.$emit('eventSelectedUser', data); // идем наверх!
		
		if(!data.handeled) $location.path('/user/'+data.entity.idUser+'/update');
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
		        $compile(angular.element(row).attr('ng-click','onRowClick($event)'))($scope);
			}

    	}
    	,dtColumns:[
    		{'data':'idVehicleModel','title':'ID'}
    		,{'data':'descr','title':'Descr'}
	        ]
    	,dtInstance:{}
		};
	
	$scope.onRowClick = function(event){
		var row = angular.element(event.currentTarget);
		
		var data = {
			entity:$scope.vm.dtInstance.DataTable.row(row).data(),
			handeled:false
		};
		
		$scope.$emit('eventSelectedModel', data); // идем наверх!
		
		if(!data.handeled) $location.path('/vehicle/model/'+data.entity.idVehicleModel+'/update');
	};
	
}])
.controller('type',['$scope','$routeParams','$location','$http','$formUtils','$compile',function($scope,$routeParams,$location,$http,$formUtils,$compile){
	
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
			,'createdRow':function(row){
		        $compile(angular.element(row).attr('ng-click','onRowClick($event)'))($scope);
			}
    	}
		,dtInstance:{}
    	,dtColumns:[
    		{'data':'idVehicleType','title':'ID'}
    		,{'data':'descr','title':'Descr'}
	        ]
		};
	
	$scope.onRowClick = function(event){
		var row = angular.element(event.currentTarget);
		
		var data = {
			entity:$scope.vm.dtInstance.DataTable.row(row).data(),
			handeled:false
		};
		
		$scope.$emit('eventSelectedType', data); // идем наверх!
		
		if(!data.handeled) $location.path('/vehicle/type/'+data.entity.idVehicleType+'/update');
	};
	
}])
.controller('rentalPoint',['$scope','$routeParams','$location','$http','$formUtils','$compile',function($scope,$routeParams,$location,$http,$formUtils,$compile){
	
	$scope.title="Rental point";
	
	$scope.form_model = {
		columns:{
			'idRentalPoint':{'title':'ID','value':null}
			,'address':{'title':'Address','value':null}
		}
		,form_action_url:'/rental/point/save'
		,message:""	
	};
	
	
	
	if($routeParams.id){
		$formUtils.loadModel(
			$scope.form_model
			,"/rental/point/"+$routeParams.id
			,$scope.form_model.message
		);
	}else{
		delete $scope.form_model.columns['idRentalPoint'];
	}
	
	$scope.saveFormSubmit= function(){
		$formUtils.save(
			$scope.form_model
			,"/rental/point/save"
			,"/rental/point"
		);
	};

	
	$scope.vm=
		{dtOptions:{
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'rental/point/list',
    			'dataSrc':"data"
    		}
			,'createdRow':function(row){
		        $compile(angular.element(row).attr('ng-click','onRowClick($event)'))($scope);
			}
    	}
		,dtInstance:{}
    	,dtColumns:[
    		{'data':'idRentalPoint','title':'ID'}
    		,{'data':'address','title':'Address'}
	        ]
		};
	
	$scope.onRowClick = function(event){
		var row = angular.element(event.currentTarget);
		
		var data = {
			entity:$scope.vm.dtInstance.DataTable.row(row).data(),
			handeled:false
		};
		
		$scope.$emit('eventSelectedRentalPoint', data); // идем наверх!
		
		if(!data.handeled) $location.path('/rental/point/'+data.entity.idRentalPoint+'/update');
	};
	
}])
.controller('customer',['$scope','$routeParams','$location','$http','$formUtils','$compile',function($scope,$routeParams,$location,$http,$formUtils,$compile){
	
	$scope.title="Customer";
	
	$scope.form_model = {
		columns:{
			'idCustomer':{'title':'ID','value':null}
			,'descr':{'title':'Customer full name','value':null}
		}
		,form_action_url:'/customer/save'
		,message:""	
	};
	
	
	
	if($routeParams.id){
		$formUtils.loadModel(
			$scope.form_model
			,"/customer/"+$routeParams.id
			,$scope.form_model.message
		);
	}else{
		delete $scope.form_model.columns['idCustomer'];
	}
	
	$scope.saveFormSubmit= function(){
		$formUtils.save(
			$scope.form_model
			,"/customer/save"
			,"/customer"
		);
	};

	
	$scope.vm=
		{dtOptions:{
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'customer/list',
    			'dataSrc':"data"
    		}
			,'createdRow':function(row){
		        $compile(angular.element(row).attr('ng-click','onRowClick($event)'))($scope);
			}
    	}
		,dtInstance:{}
    	,dtColumns:[
    		{'data':'idCustomer','title':'ID'}
    		,{'data':'descr','title':'Full name'}
	        ]
		};
	
	$scope.onRowClick = function(event){
		var row = angular.element(event.currentTarget);
		
		var data = {
			entity:$scope.vm.dtInstance.DataTable.row(row).data(),
			handeled:false
		};
		
		$scope.$emit('eventSelectedCustomer', data); // идем наверх!
		
		if(!data.handeled) $location.path('/customer/'+data.entity.idCustomer+'/update');
	};
	
}])
.controller('UtilCtrl',['$scope','$location','$window','$timeout','$formUtils',function($scope,$location,$window,$timeout,$formUtils){

	$scope.$location = $location;

	$scope.messages = $formUtils.getMessages();

	$scope.$watch('messages',MessagesClean,true);
	
	var msgCleanTimeout = null; 
	
	function MessagesClean() {
		$timeout.cancel(msgCleanTimeout);
		msgCleanTimeout = $timeout(function () {
        	$formUtils.cleanMessages();
        }, 5000);
    }

}])
.controller('vehicle',['$scope','$routeParams','$location','$http','$formUtils','$compile',function($scope,$routeParams,$location,$http,$formUtils,$compile){
	
	$scope.title="Vehicle";
	
	$scope.form_model = {
		columns:{
			'idVehicle':{'title':'ID','value':null}
			,'regNum':{'title':'Reg num','value':null}
			,'lastRental':{'title':'Last rental','value':null}			
			,'rentalPoint':{'title':'rentalPoint','value':null}	
			,'vehicleModel':{'title':'Vehicle model','value':null,'controller':'model'}
			,'vehicleType':{'title':'Vehicle type','value':null,'controller':'type'}
			,'rentalPoint':{'title':'RentalPoint','value':null,'controller':'rentalPoint'}
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
    		}			,'createdRow':function(row){
		        $compile(angular.element(row).attr('ng-click','onRowClick($event)'))($scope);
			}
    	}
		,dtInstance:{}
    	,dtColumns:[
    		{'data':'idVehicle','title':'ID'}
    		,{'data':'regNum','title':'Reg num'}
    		,{'data':'vehicleType.descr','title':'Vehicle type'}
    		,{'data':'vehicleModel.descr','title':'Model'}
    		,{'data':'rentalPoint.address','title':'Rental point address'}
	        ]
		};
	
	$scope.onRowClick = function(event){
		var row = angular.element(event.currentTarget);
		var entity = $scope.vm.dtInstance.DataTable.row(row).data(); 
		var data = {
			entity:$scope.vm.dtInstance.DataTable.row(row).data(),
			handeled:false
		};
		
		$scope.$emit('eventSelectedVehicle', data); // идем наверх!
		
		if(!data.handeled) $location.path('/vehicle/'+data.entity.idVehicle+'/update')
	};	
	
	$scope.selectEntity=function(ctrl,$event,loadTo){
		var element = angular.element($event.currentTarget);
		$formUtils.selectFormOpen(ctrl,element,loadTo);
	};
	
}])
.controller('rental',['$scope','$routeParams','$location','$http','$formUtils','$compile',function($scope,$routeParams,$location,$http,$formUtils,$compile){
	
	$scope.title="Rental";
	
	$scope.form_model = {
		columns:{
			'idRental':{'title':'ID','value':null}
			,'customer':{'title':'Customer','value':null,'controller':'customer'}
			,'vehicle':{'title':'Vehicle','value':null,'controller':'vehicle'}
			,'rentalStart':{'title':'Rental start time','value':null,'type':'date','opened':false,'options':{'startingDay': 1}}
			,'pointFrom':{'title':'Point issuance','value':null,'controller':'rentalPoint'}
			,'pointTo':{'title':'Point reception','value':null,'controller':'rentalPoint'}
			,'rentalEnd':{'title':'Rental end time','value':null,'type':'date','opened':false,'options':{'startingDay': 1}}
			,'notes':{'title':'Notes','value':null}
		}
		,form_action_url:'/rental/save'
		,message:""	
	};
	
	
	
	if($routeParams.id){
		$formUtils.loadModel(
			$scope.form_model
			,"/rental/"+$routeParams.id
			,$scope.form_model.message
		);


		
	}else{
		delete $scope.form_model.columns['idRental'];
	}
	
	$scope.$watch('form_model.columns.vehicle.value',function(){
		var vehicleVal = $scope.form_model.columns.vehicle.value;
		if(vehicleVal && vehicleVal.vehicleModel){
			$scope.form_model.columns.vehicle.value = {
				idVehicle:vehicleVal.idVehicle,
				regNum:vehicleVal.regNum,
				model:vehicleVal.vehicleModel.descr,
				type:vehicleVal.vehicleType.descr,
				rentalPointAddress:vehicleVal.rentalPoint.address
			};		
		}	
	});
	
	$scope.$watch('form_model.columns.rentalStart.value',function(){
		var d = $scope.form_model.columns.rentalStart.value;
		if(d && !angular.isDate(d))
			try{$scope.form_model.columns.rentalStart.value = new Date(d);}catch(e){}
	});
	$scope.$watch('form_model.columns.rentalEnd.value',function(){
		var d = $scope.form_model.columns.rentalEnd.value;
		if(d && !angular.isDate(d))
			try{$scope.form_model.columns.rentalEnd.value = new Date(d);}catch(e){}
	});
	
	$scope.saveFormSubmit= function(){
		$formUtils.save(
			$scope.form_model
			,"/rental/save"
			,"/rental"
		);
	};

	var render =  function ( data, type, row, meta ) {
		if(null==data)return data;
		try{
			var d = new Date(data);
			var s = d.toLocaleDateString()+" "+d.toLocaleTimeString();
			return s;
		}catch(e){
			alert(e);
		}
		return data;
	}
	
	$scope.vm=
		{dtOptions:{
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'contentType': 'application/json',
    			'url':'rental/list',
    			'dataSrc':"data"
    		}			,'createdRow':function(row){
		        $compile(angular.element(row).attr('ng-click','onRowClick($event)'))($scope);
			}
    	}
		,dtInstance:{}
    	,dtColumns:[
    		{'data':'idRental','title':'ID'}
    		,{'data':'customer.descr','title':'Customer full name'}
    		,{'data':'vehicle.regNum','title':'Vehicle reg num'}
    		,{'data':'vehicle.vehicleModel.descr','title':'Vehicle model'}
    		,{'data':'rentalStart','title':'Rental start time','render':render}
    		,{'data':'rentalEnd','title':'Rental end time','render':render}
    		,{'data':'notes','title':'Notes'}
	        ]
		};
	
	
	$scope.onRowClick = function(event){
		var row = angular.element(event.currentTarget);
		
		var data = {
			entity:$scope.vm.dtInstance.DataTable.row(row).data(),
			handeled:false
		};
		
		$scope.$emit('eventSelectedRental', data); // идем наверх!
		
		if(!data.handeled) $location.path('/rental/'+data.entity.idRental+'/update')
	};	
	
	$scope.selectEntity=function(ctrl,$event,loadTo){
		var element = angular.element($event.currentTarget);
		$formUtils.selectFormOpen(ctrl,element,loadTo);
	};
	
}])
.controller('index',['$scope',function($scope){}]);