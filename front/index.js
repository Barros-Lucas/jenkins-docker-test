function sendUserName(){
	var userName = $("#userName").val();
var url = "http://90.89.7.235:8082/nbViewers?boxname=textBox&username="+userName
				$.get(url, function( data ) {
				  $("#textBox").text(data);
				});
var url = "http://90.89.7.235:8082/nbViewers?boxname=textBox2&username="+userName
				$.get(url, function( data ) {
				  $("#textBox2").text(data);
				});
}

function fillCompareColumn(index) {
	var userCompare = $("#userCompare").val();
	$("#user" + index).text(userCompare);
}
