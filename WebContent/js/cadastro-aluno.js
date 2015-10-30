$().ready(
		function() {
			$('#add').click(
					function() {
						return !$('#disciplinas option:selected').remove()
								.appendTo('#disciplinas_selecionadas');
					});
			$('#remove').click(
					function() {
						return !$('#disciplinas_selecionadas option:selected')
								.remove().appendTo('#disciplinas');
					});
		});
$().ready(
		function() {
			$('#add').click(
					function() {
						return !$('#disciplinas option:selected').remove()
								.appendTo('#disciplinas_selecionadas');
					});
			$('#remove').click(
					function() {
						return !$('#disciplinas_selecionadas option:selected')
								.remove().appendTo('#disciplinas');
					});
		});

$('form').submit(function() {
	$('#disciplinas_selecionadas option').each(function(i) {
		$(this).attr("selected", "selected");
	});
});