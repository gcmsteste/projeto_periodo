$(document).ready(function() {

	$('a.toggler').click(function() {
		$(this).toggleClass('off');
		var strategy = $(this).text();
		if (strategy == "JPA") {
			$(this).text('JDBC');
		} else if (strategy == "JDBC") {
			$(this).text("JPA");
		}
		strategy = $(this).text();

		$.post("alterarEstrategiaPersistencia", {
			persistencia : strategy
		});

	});
});