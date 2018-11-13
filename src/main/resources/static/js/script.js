$(document).ready(function() {
	if ($(".alert").length) {					
		window.setTimeout(function() {
			$(".alert").slideUp("slow", function() {							
				$(".alert").alert("close");
			});
		}, 3000);
	}
});