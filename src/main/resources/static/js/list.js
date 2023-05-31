$(function() {
	$("#sort").on("change",()=>{
		window.location = "http://localhost:8080/list/"+$("#sort").val();
	});
});