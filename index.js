function sendUserName(){
	var userName = $("#userName").val();
	var url = "http://90.89.7.235:8081/getViewerCount?boxname=nbviewers1&username="+userName
	$.get(url, function( data ) {
	  $("#nbviewers1").text(data);
	});
}
