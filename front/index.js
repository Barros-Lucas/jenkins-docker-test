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
}

function fillCompareColumn(index) {
	var userCompare = $("#userCompare").val();
	$("#user" + index).text(userCompare);
var url = "http://90.89.7.235:8082/getViewerCount?boxname=table&username="+userCompare
					$.get(url, function( data ) {
					  $("#getViewerCount + index").text(data);
					});
var url = "http://90.89.7.235:8082/getFollowers?boxname=table&username="+userCompare
					$.get(url, function( data ) {
					  $("#getFollowers + index").text(data);
					});
}
