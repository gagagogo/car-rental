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
				this.messages.length = 0;
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
		    			var errors = response.data.errors
		    			for(i=0;i<errors.length;i++)
		    				formUtils.addMessage((errors[i].hasOwnProperty('field')?errors[i].field+" ":"")+errors[i].defaultMessage);
		    		} 
		    		
		    	  }, function errorCallback(response) {
		    		  formUtils.addMessage("Some thing wrong with request");
		    	  });				
			}
			,selectFormOpen:function(ctrl,elementCaller,loadTo){
				var callerScope = elementCaller.scope();
				
			    var win = $uibModal.open({
			        template: '<table datatable="" dt-options="vm.dtOptions" dt-columns="vm.dtColumns" dt-instance="vm.dtInstance" class="row-border hover"></table>',
			        controller: ctrl,
			        animation:false,
			        scope:callerScope
			      });
			    
			    var eventName = 'eventSelected'+ctrl.charAt(0).toUpperCase() + ctrl.substr(1); //capitalize
			    	
			    callerScope.$on(eventName,function(event, data){
			    	loadTo.value = data.entity;
			    	win.close(data);
			    	data.handeled = true;
			    });
			}
			
	};
	
	return formUtils;
});