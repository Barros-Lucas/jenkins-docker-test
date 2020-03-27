function sendUserName(){
	var userName = $("#userName").val();
var url = "http://90.89.7.235:8082/getViewerCount?boxname=nbviewers1&username="+userName
				$.get(url, function( data ) {
				  $("#nbviewers1").text(data);
				});
var url = "http://90.89.7.235:8082/getProfilePict?boxname=image1&username="+userName
				$.get(url, function( data ) {
				  $("#image1").attr("src", data);
				});
var url = "http://90.89.7.235:8082/getViewerCount?boxname=nbviewers1&username="+userName
				$.get(url, function( data ) {
				  $("#nbviewers1").text(data);
				});
var url = "http://90.89.7.235:8082/getViewerCount?boxname=nbViewerss3&username="+userName
				$.get(url, function( data ) {
				  $("#nbViewerss3").text(data);
				});
}

function fillCompareColumn(index) {
	var userCompare = $("#userCompare").val();
	$("#user" + index).text(userCompare);
var url = "http://90.89.7.235:8082/getViewerCount?boxname=table&username="+userCompare
					$.get(url, function( data ) {
					  $("#getViewerCount + index").text(data);
					});
}
