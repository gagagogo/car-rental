angular.module('CarRental.services', ['spring-security-csrf-token-interceptor'])
.factory('$formUtils',function($http,$window){
	var formUtils = {
			loadModel:function(formModel,url){
				$http({
					  "method"  : 'GET',
					  "url"     : url
				})
		    	.then(function successCallback(response) {
		    		messageList= [];
		    		if(response.status==200) {
		    			for(column in formModel.columns){
		    				formModel.columns[column].value = response.data[column];
		    			}
		    		}
		    		else{
		    			formModel.message = response.data.message;
		    		} 
		    		
		    	  }, function errorCallback(response) {
		    		  formModel.message="Some thing wrong with request";
		    	  });
			}
			,save(formModel,url){
				var data = {};
				for(column in formModel.columns){
					data[column] = formModel.columns[column].value; 
	    		}

					
				$http({
					  "method"  : 'POST'
					  ,"url"    : url
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
		    			formModel.message = "User successfuly updated";
		    		}
		    		else{
		    			formModel.message = response.data.message;
		    		} 
		    		
		    	  }, function errorCallback(response) {
		    		  formModel.message="Some thing wrong with request";
		    	  });				
			}
	};
	
	return formUtils;
});