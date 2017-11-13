function jQueryMobile(input){
	//Sólo para Prime JQuery Mobile
	//----------------------------
	//Por defecto a los id de los input text. El jquery agrega el sufijo: _input
	//Ejem: my_text -> my_text_input
	//document.getElementById("my_text_input")
	//document.getElementById("my_text_input").value
	
	//Esto es para el Primefaces web
	//var cant=jQuery('#form\\:txtCantidad').val();            	            	
	//jQuery('#form\\:txtCantidad2').val(cant);
	
	return document.getElementById(input+"_input");
}

function actualizarCant(valor){
	
	//var cant=jQuery('#form\\:varcantidad').val();
	//var nuevo = parseInt(cant) + parseInt(valor);
	//jQuery('#form\\:varcantidad').val(nuevo);
	//var cant  = document.getElementById("form:varcantidad");
	//var cantH = document.getElementById("form:varcantidadHidden");
	//cantH.value = cant;
	/*if(cant=='' || isNaN(cant)){					
		cant.value=1;
	}	
	var nuevo = parseInt(cant.value) + parseInt(valor);
	if (parseInt(nuevo)>=1){
		cant.value  = nuevo;
		//cantH.value = nuevo;
	}*/
	
	var cant  = jQueryMobile("form:varcantidad");	
	if(cant.value=='' || isNaN(cant.value)){					
		cant.value=1;
	}
	var nuevo = parseInt(cant.value) + parseInt(valor);
	if(nuevo>0)//Cantidad minima = 1
		cant.value = nuevo;	
}


function verBarraPedidos(){
	var cantPedOrig  = document.getElementById("form:cantPedidosOrig");

	var nnn = parseInt(cantPedOrig.value);
	if (nnn>1)
		document.getElementById('divpedidos').style.display='block';
}

function verBarraPedidos2(){
	var cantPedOrig  = document.getElementById("form:cantPedidosOrig");

	var nnn = parseInt(cantPedOrig.value);
	if (nnn>5)
		document.getElementById('divpedidos2').style.display='block';
}


function iniciarCant(){
	var cant  = document.getElementById("form:varcantidad");
	cant.value  = 1;
}


function jsSoloNumerosEnteros(e) {
    key = e.keyCode || e.which;
    //key = e.keyCode;
    //alert(e.keyCode+"-"+e.which);
    if ( //(key==46) || //suprimir
    	 (key==8)  ||  //backspace
         (key==36) ||  //inicio
         (key==35) ||  //fin
         (key==37) ||  //flecha izquierda
         (key==39) ||  //flecha derecha
         (key==13) ||  //enter
         (key==9) )    //tab
       return true;
    var t = String.fromCharCode(key).toLowerCase();		    
    var numeros = "0123456789";
    if(numeros.indexOf(t) != -1){
    	return true;
    }else{
    	return false;
    }
}