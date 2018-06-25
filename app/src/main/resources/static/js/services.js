angular.module('CarRental.services', ['spring-security-csrf-token-interceptor','ui.bootstrap'])
.factory('$formUtils',function($http,$window,$location,$uibModal){
	var formUtils = {
			messages:[]
			,getMessages:function(){
				return this.messages;
			}
			,addMessage:function(msg){
				this.getMessages().push(msg);
			}
			,cleanMessages(){
				this.messages = [];
			}
			,loadModel:function(formModel,url){
				$http({
					  "method"  : 'GET',
					  "url"     : url
				})
		    	.then(function successCallback(response) {
		    		if(response.status==200) {
		    			for(column in formModel.columns){
		    				formModel.columns[column].value = response.data[column];
		    			}
		    		}
		    		else{
		    			formUtils.addMessage(response.data.message);
		    		} 
		    		
		    	  }, function errorCallback(response) {
		    		  formUtils.addMessage("Some thing wrong with request");
		    	  });
			}
			,save:function(formModel,actionUrl,successUrl){
				var data = {};
				for(column in formModel.columns){
					data[column] = formModel.columns[column].value; 
	    		}
					
				$http({
					  "method"  : 'POST'
					  ,"url"    : actionUrl
					  ,"data"	: JSON.stringify(data)
					  ,"headers": {
	                        "Content-Type": "application/json"
					  }
				})
		    	.then(function successCallback(response) {
		    		if(response.status==200) {
		    			for(column in formModel.columns){
		    				formModel.columns[column].value = response.data[column];
		    			}
		    			formUtils.addMessage("Record successfuly saved");
		    			$location.path(successUrl);
		    		}
		    		else{
		    			formUtils.addMessage(response.data.message);
		    		} 
		    		
		    	  }, function errorCallback(response) {
		    		  this.addMessage("Some thing wrong with request");
		    	  });				
			}
			,selectFormOpen:function(ctrl){
			    $uibModal.open({
			        template: '<table datatable="" dt-options="vm.dtOptions" dt-columns="vm.dtColumns" class="row-border hover"></table>',
			        controller: ctrl,
			        resolve:function(){
			        	vm:{
			        		dtColumns:[
			        			{'render':function ( data, type, row ) {return data;}}
			        			]
			        		}
			        }
			      });
			}
			
	};
	
	return formUtils;
});