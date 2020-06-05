      	var grid = GridStack.init();
      	var myBarChart;
      	window.onload = function (){












var chartData = {
	                labels: [],
	                datasets: [
	                
	                 {
		fillColor: "#79D1CF",
                    	strokeColor: "#79D1CF",
		data: []
	}

                    ]
	            };

	            var ctx = document.getElementById("graph").getContext("2d");
	            myBarChart = new Chart(ctx, {
	                type: 'bar',
	                data: chartData,
	            });



}

                  
function addData(chart, label, data) {
	chart.data.labels.push(label);
	chart.data.datasets.forEach((dataset) => {
		dataset.data.push(data);
	});
	chart.update();
}

function removeData(chart) {
	chart.data.labels.pop();
	chart.data.datasets.forEach((dataset) => {
		dataset.data.pop();
	});
	chart.update();
}

function sendUserName(widget){
	
		    	if (widget == "nbviewers1")
		    	{
		    		var userName = $("#inputnbviewers1").val();
			    	var url = "http://86.195.220.29:8082/getViewerCount?username="+userName
					$.get(url, function( data ) {
					  $("#nbviewers1").text(data);
					});
				}
	
	
		    	if (widget == "nbviewers2")
		    	{
		    		var userName = $("#inputnbviewers2").val();
			    	var url = "http://86.195.220.29:8082/getViewerCount?username="+userName
					$.get(url, function( data ) {
					  $("#nbviewers2").text(data);
					});
				}
	
	
	
	if (widget == "image1")
	{
	    var userName = $("#inputimage1").val();
			    	var url = "http://86.195.220.29:8082/getProfilePict?username="+userName
		$.get(url, function( data ) {
		  $("#image1").attr("src", data);
		});
	}
	
	
	if (widget == "image2")
	{
	    var userName = $("#inputimage2").val();
			    	var url = "http://86.195.220.29:8082/getProfilePict?username="+userName
		$.get(url, function( data ) {
		  $("#image2").attr("src", data);
		});
	}
	
	
	
	
}

function updateGraph (widget){
	
	
	
	
	
	
	
		    	if (widget == "graph")
		    	{
		    		var res = [];
		    		var label = [];
		    		var usernames = document.getElementsByClassName("inputgraph");
		    		var input_mixer = document.getElementsByClassName("inputmixergraph");
		    		var input_twitch = document.getElementsByClassName("inputtwitchgraph");
		    		
	    		    for(var i=0; i < usernames.length; i++)
	    		    {
	    		    	if(input_mixer[i].checked == true)
	    		    	{
	    		    		var url = "http://86.195.220.29:8082/getViewerCount?username="+usernames[i].value+"&apiType=mixer";
	    		    		console.log(url);
							$.get(url, function( data ) {
								console.log(data);
								res.push(data);
								label.push(usernames[i]);
							});
								
	    		    	}else{
	    		    		
	    		    		var url = "http://86.195.220.29:8082/getViewerCount?username="+usernames[i].value+"&apiType=twitch";
							console.log(url);
							$.get(url, function( data ) {
							 console.log(data);
							 res.push(data);
							 label.push(usernames[i]);
							});
	    		    		
	    		    	}

	    		    }	 
	    		    
	    		    setTimeout(() => {  
	    		    					    		    						
    					console.log(res);
    					removeData(myBarChart);
    					console.log(res);
    					for (var i = 0; i < res.length; i++){
    						addData(myBarChart, label[i], res[i])
    					}
    				
    			    }, 5000);
	    		    				   		  		    
					
				}
				
				
	
	
}

function fillCompareColumn(index) {
	var userCompare = $("#userCompare").val();
	$("#user" + index).text(userCompare);
var url = "http://86.195.220.29:8082/getViewerCount?username="+userCompare
					$.get(url, function( data ) {
					  $("#getViewerCount" + index).text(data);
					});
var url = "http://86.195.220.29:8082/getFollowers?username="+userCompare
					$.get(url, function( data ) {
					  $("#getFollowers" + index).text(data);
					});
}
