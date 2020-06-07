      	var grid = GridStack.init();
      	var myBarChart;
      	var listGraph = new Map();
      	var ctx;
      	var color = ["#0275d8", "#5cb85c", "#5bc0de"];
      	var color2 = ["#f0ad4e", "#d9534f", "#292b2c"];
      	window.onload = function (){
















var chartData = {
	                labels: [],
	                datasets: [
	                
	                 {
	                 	label : "getViewerCount",
		data: [],
			        	fillColor: "#E7E7E7", 
			        	strokeColor: "#E7E7E7",
			        	backgroundColor: "#E7E7E7", 
		
		
	}

                    ]
	            };

	            ctx = document.getElementById("Histogramme").getContext("2d");
	            
	            myBarChart = new Chart(ctx, {
	                type: 'bar',
	                data: chartData,
	            });
	            listGraph.set("Histogramme", myBarChart)





					
var chartData = {
	                labels: [],
	                datasets: [
		                {
		                	label : "getFollowers",
			data: [],
			backgroundColor : []
		}

	                ]
	            };
	
	            var ctx = document.getElementById("Piechart").getContext("2d");
	            myBarChart = new Chart(ctx, {
	                type: 'pie',
	                data: chartData,
	            });
	            listGraph.set("Piechart", myBarChart)


}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

                  
function addData(chart, label, data, type) {
	chart.data.labels.push(label);
	chart.data.datasets.forEach((dataset) => {
		dataset.data.push(data);
		if (type == "piechart") dataset.backgroundColor.push(getRandomColor())
	});
	chart.update();
}

function removeData(chart) {
	chart.data.labels.splice(0, chart.data.labels.length);
	chart.data.datasets.forEach((dataset) => {
		dataset.data.splice(0, dataset.data.length);
	});
	chart.update();
}


function sendUserName(widget){
	
	
	if (widget == "Corobizar")
	{
	    var userName = $("#inputCorobizar").val();
			    	
			    	
			    	var input_mixer = $("#inputmixerCorobizar");
			    	var input_twitch =  $("#inputtwitchCorobizar");
			    	if(input_mixer.is(':checked')){
			    	   
			    	   var url = "http://86.195.220.29:8082/getProfilePict?username="+userName+"&apiType=mixer";
		    	    
		    	    } else if (input_twitch.is(':checked')){
		    	       
		    	        var url = "http://86.195.220.29:8082/getProfilePict?username="+userName+"&apiType=twitch";
		    	        console.log(url)
		    	    }else {
		    	    	
		    	    	alert ("Please choose a type")	
		    	    }
			    	
		$.get(url, function( data ) {
			console.log(data)
		  	$("#Corobizar").attr("src", data);
		});
	}
	
		    	if (widget == "FollowersCoro")
		    	{
		    		var userName = $("#inputFollowersCoro").val();
			    	
			    	
			    	var input_mixer = $("#inputmixerFollowersCoro");
			    	var input_twitch =  $("#inputtwitchFollowersCoro");
			    	if(input_mixer.is(':checked')){
			    	   
			    	   var url = "http://86.195.220.29:8082/getFollowers?username="+userName+"&apiType=mixer";
		    	    
		    	    } else if (input_twitch.is(':checked')){
		    	       
		    	       var url = "http://86.195.220.29:8082/getFollowers?username="+userName+"&apiType=twitch";
		    	    
		    	    }else {
		    	    	
		    	    	alert ("Please choose a type")	
		    	    }
$.get(url, function( data ) {
  $("#FollowersCoro").text(data);
});
				}
	
	
	
	if (widget == "ObiBertKenobi")
	{
	    var userName = $("#inputObiBertKenobi").val();
			    	
			    	
			    	var input_mixer = $("#inputmixerObiBertKenobi");
			    	var input_twitch =  $("#inputtwitchObiBertKenobi");
			    	if(input_mixer.is(':checked')){
			    	   
			    	   var url = "http://86.195.220.29:8082/getProfilePict?username="+userName+"&apiType=mixer";
		    	    
		    	    } else if (input_twitch.is(':checked')){
		    	       
		    	        var url = "http://86.195.220.29:8082/getProfilePict?username="+userName+"&apiType=twitch";
		    	        console.log(url)
		    	    }else {
		    	    	
		    	    	alert ("Please choose a type")	
		    	    }
			    	
		$.get(url, function( data ) {
			console.log(data)
		  	$("#ObiBertKenobi").attr("src", data);
		});
	}
	
		    	if (widget == "FollowersObi")
		    	{
		    		var userName = $("#inputFollowersObi").val();
			    	
			    	
			    	var input_mixer = $("#inputmixerFollowersObi");
			    	var input_twitch =  $("#inputtwitchFollowersObi");
			    	if(input_mixer.is(':checked')){
			    	   
			    	   var url = "http://86.195.220.29:8082/getFollowers?username="+userName+"&apiType=mixer";
		    	    
		    	    } else if (input_twitch.is(':checked')){
		    	       
		    	       var url = "http://86.195.220.29:8082/getFollowers?username="+userName+"&apiType=twitch";
		    	    
		    	    }else {
		    	    	
		    	    	alert ("Please choose a type")	
		    	    }
$.get(url, function( data ) {
  $("#FollowersObi").text(data);
});
				}
	
	
	
	if (widget == "KaribouCanadien")
	{
	    var userName = $("#inputKaribouCanadien").val();
			    	
			    	
			    	var input_mixer = $("#inputmixerKaribouCanadien");
			    	var input_twitch =  $("#inputtwitchKaribouCanadien");
			    	if(input_mixer.is(':checked')){
			    	   
			    	   var url = "http://86.195.220.29:8082/getProfilePict?username="+userName+"&apiType=mixer";
		    	    
		    	    } else if (input_twitch.is(':checked')){
		    	       
		    	        var url = "http://86.195.220.29:8082/getProfilePict?username="+userName+"&apiType=twitch";
		    	        console.log(url)
		    	    }else {
		    	    	
		    	    	alert ("Please choose a type")	
		    	    }
			    	
		$.get(url, function( data ) {
			console.log(data)
		  	$("#KaribouCanadien").attr("src", data);
		});
	}
	
		    	if (widget == "FollowersKaribou")
		    	{
		    		var userName = $("#inputFollowersKaribou").val();
			    	
			    	
			    	var input_mixer = $("#inputmixerFollowersKaribou");
			    	var input_twitch =  $("#inputtwitchFollowersKaribou");
			    	if(input_mixer.is(':checked')){
			    	   
			    	   var url = "http://86.195.220.29:8082/getFollowers?username="+userName+"&apiType=mixer";
		    	    
		    	    } else if (input_twitch.is(':checked')){
		    	       
		    	       var url = "http://86.195.220.29:8082/getFollowers?username="+userName+"&apiType=twitch";
		    	    
		    	    }else {
		    	    	
		    	    	alert ("Please choose a type")	
		    	    }
$.get(url, function( data ) {
  $("#FollowersKaribou").text(data);
});
				}
	
	
	
	
	
	
	
}

function updateGraph (widget, type){
	jQuery.ajaxSetup({async:false});
	
	
	
	
	
	
	
	
	    	if (widget == "Histogramme")
	    	{
	    		var res = [];
	    		var label = [];
	    		var usernames = document.getElementsByClassName("inputHistogramme");
	    		removeData(listGraph.get("Histogramme"));
	    		var user = "";
	    		var input_mixer = document.getElementsByClassName("inputmixerHistogramme");
	    		var input_twitch = document.getElementsByClassName("inputtwitchHistogramme");
	    		

    		    for(var i=0; i < usernames.length; i++)
    		    {
    		    	user = usernames[i].value
    		    	if(input_mixer[i].checked == true)
    		    	{	    		    		
    		    		var url = "http://86.195.220.29:8082/getViewerCount?username="+user+"&apiType=mixer";
    		    		console.log(url);
							$.get(url, function( data ) {
								console.log(data);
								addData(listGraph.get("Histogramme"), user, data, type)
							});
								
    		    	}else{
    		    		
    		    		var url = "http://86.195.220.29:8082/getViewerCount?username="+user+"&apiType=twitch";
							console.log(url);
							$.get(url, function( data ) {
							 console.log(data);
							 addData(listGraph.get("Histogramme"), user, data, type)
							});
    		    		
    		    	}
    		    	
    		    	
    		    	
    		    }	 	    		    				   		  		    	
			}
	
	    	if (widget == "Piechart")
	    	{
	    		var res = [];
	    		var label = [];
	    		var usernames = document.getElementsByClassName("inputPiechart");
	    		removeData(listGraph.get("Piechart"));
	    		var user = "";
	    		var input_mixer = document.getElementsByClassName("inputmixerPiechart");
	    		var input_twitch = document.getElementsByClassName("inputtwitchPiechart");
	    		

    		    for(var i=0; i < usernames.length; i++)
    		    {
    		    	user = usernames[i].value
    		    	if(input_mixer[i].checked == true)
    		    	{	    		    		
    		    		var url = "http://86.195.220.29:8082/getFollowers?username="+user+"&apiType=mixer";
    		    		console.log(url);
							$.get(url, function( data ) {
								console.log(data);
								addData(listGraph.get("Piechart"), user, data, type)
							});
								
    		    	}else{
    		    		
    		    		var url = "http://86.195.220.29:8082/getFollowers?username="+user+"&apiType=twitch";
							console.log(url);
							$.get(url, function( data ) {
							 console.log(data);
							 addData(listGraph.get("Piechart"), user, data, type)
							});
    		    		
    		    	}
    		    	
    		    	
    		    	
    		    }	 	    		    				   		  		    	
			}
	jQuery.ajaxSetup({async:true});
	
}

function fillCompareColumn(index) {
var userCompare = $("#Equipe" + index).val();
$("th#Equipeuser" + index).text(userCompare);
var checkboxTwitch = $("#inputtwitchEquipe" + index);
var checkboxMixer = $("#inputmixerEquipe" + index);
	    		    	if(checkboxMixer.is(':checked'))
	    		    	{	    		    		
	    		    		var url = "http://86.195.220.29:8082/getViewerCount?username="+userCompare+"&apiType=mixer";
	    		    		console.log(url);
	$.get(url, function( data ) {
	  $("#EquipegetViewerCount" + index).text(data);
	});
	    		    	}else if (checkboxTwitch.is(':checked')) {
	    		    		var url = "http://86.195.220.29:8082/getViewerCount?username="+userCompare+"&apiType=twitch";
	console.log(url);
	$.get(url, function( data ) {
		$("#EquipegetViewerCount" + index).text(data);
	});
	    		    	}
var checkboxTwitch = $("#inputtwitchEquipe" + index);
var checkboxMixer = $("#inputmixerEquipe" + index);
	    		    	if(checkboxMixer.is(':checked'))
	    		    	{	    		    		
	    		    		var url = "http://86.195.220.29:8082/getFollowers?username="+userCompare+"&apiType=mixer";
	    		    		console.log(url);
	$.get(url, function( data ) {
	  $("#EquipegetFollowers" + index).text(data);
	});
	    		    	}else if (checkboxTwitch.is(':checked')) {
	    		    		var url = "http://86.195.220.29:8082/getFollowers?username="+userCompare+"&apiType=twitch";
	console.log(url);
	$.get(url, function( data ) {
		$("#EquipegetFollowers" + index).text(data);
	});
	    		    	}
}
