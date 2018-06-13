'use strict';

angular.module('CarRental.controllers', [])
.controller('login',['$scope',function($scope){}])
.controller('user',['$scope','$window','DTColumnBuilder',function($scope,$window,DTColumnBuilder){
    var vm = this;
    vm.dtOptions = {
    		'serverSide': true,
    		"processing": true,
    		'ajax':{
    			'url':'system/user/list'
    			,'dataSrc':"content"
    			,'dataFilter': function(data){
    		            var json = jQuery.parseJSON( data );
    		            json.recordsTotal = json.totalElements;
    		            json.recordsFiltered = json.totalElements;

    		            return JSON.stringify( json ); // return JSON string
    		        }	
    			}
    	};

    vm.dtColumns = [
        DTColumnBuilder.newColumn('idUser').withTitle('ID'),
        DTColumnBuilder.newColumn('name').withTitle('Login'),
        DTColumnBuilder.newColumn('descr').withTitle('Descr')
    ];
	
}])
.controller('index',['$scope',function($scope){}])