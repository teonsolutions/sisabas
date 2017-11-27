		function validaLetras(e){
		    tecla = (document.all) ? e.keyCode : e.which;
		
		    if (tecla==8 || tecla==0){
		        return true;
		    }
		    patron =/[A-Z a-z]/;
		    tecla_final = String.fromCharCode(tecla);
		    
		    return patron.test(tecla_final);
		}
		
		function validaNumeros(e){
		    tecla = (document.all) ? e.keyCode : e.which;
		
		    if (tecla==8 || tecla==0){
		        return true;
		    }
		    patron =/[0-9]/;
		    tecla_final = String.fromCharCode(tecla);
		    
		    return patron.test(tecla_final);
		}
		
		
		function validaAlfanumerico(e){
		    tecla = (document.all) ? e.keyCode : e.which;
			
		    
		    if (tecla==8 || tecla==0){
		        return true;
		    }
		    patron =/[a-z 0-9 A-Z]/;
		    tecla_final = String.fromCharCode(tecla);
		    
		    return patron.test(tecla_final);
		}
		
		function validaDireccion(e){
		    tecla = (document.all) ? e.keyCode : e.which;
			
		    
		    if (tecla==8 || tecla==0){
		        return true;
		    }
		    patron =/[a-z 0-9 A-Z . , -]/;
		    tecla_final = String.fromCharCode(tecla);
		    
		    return patron.test(tecla_final);
		}
		
		
		function validaMoneda(e){
		    tecla = (document.all) ? e.keyCode : e.which;
			
		    
		    if (tecla==8 || tecla==0){
		        return true;
		    }
		    patron =/[0-9 .]/;
		    tecla_final = String.fromCharCode(tecla);
		    
		    return patron.test(tecla_final);
		}
		
		function validaCorreo(e){
			
		    tecla = (document.all) ? e.keyCode : e.which;
			
		    
		    
		    if (tecla==8 || tecla==0){
		    	
		        return true;
		    }
		    patron =/[a-z 0-9 A-Z . @ _]/;
		    tecla_final = String.fromCharCode(tecla);
		    
		    return patron.test(tecla_final);
		}
		
		function validaRazonSocial(e){
		    tecla = (document.all) ? e.keyCode : e.which;
			
		    
		    if (tecla==8 || tecla==0){
		        return true;
		    }
		    patron =/[a-z A-Z .]/;
		    tecla_final = String.fromCharCode(tecla);
		    
		    return patron.test(tecla_final);
		}
		
		
	
		
		
		
		
		
		
		  PrimeFaces.locales['es'] = {
	                closeText: 'Cerrar',
	                prevText: 'Anterior',
	                nextText: 'Siguiente',
	                monthNames: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
	                monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
	                dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
	                dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
	                dayNamesMin: ['D','L','M','M','J','V','S'],
	                weekHeader: 'Semana',
	                firstDay: 1,
	                isRTL: false,
	                showMonthAfterYear: false,
	                yearSuffix: '',
	                timeOnlyTitle: 'Sólo hora',
	                timeText: 'Tiempo',
	                hourText: 'Hora',
	                minuteText: 'Minuto',
	                secondText: 'Segundo',
	                currentText: 'Fecha actual',
	                ampm: false,
	                month: 'Mes',
	                week: 'Semana',
	                day: 'Día',
	                allDayText : 'Todo el día'
	        };
	        
		
	