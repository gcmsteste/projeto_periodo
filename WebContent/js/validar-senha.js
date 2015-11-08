function validar(){
	var x = document.getElementById("form1");
	if (x.senha.value != x.confirmasenha.value) {
	      alert('As senhas informadas são diferentes!');
	        x.senha.focus();
	       return false;
	}

}