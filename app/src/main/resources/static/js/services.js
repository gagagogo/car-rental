angular.module('CarRental.services', ['spring-security-csrf-token-interceptor'])
.factory('$formUtils',function($http,$window,$location){
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
			,save(formModel,actionUrl,successUrl){
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
	};
	
	return formUtils;
});