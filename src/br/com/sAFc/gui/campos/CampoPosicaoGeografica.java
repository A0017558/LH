package br.com.sAFc.gui.campos;

import util.StringManager;
import br.com.sAFc.gui.oo.OperadorObjetosAbstratoSAFC;
import formularios.ObjetoNegocio;

public class CampoPosicaoGeografica  extends CampoFormularioSAFC {

	private CampoFormularioIntSAFC campoLatitude = null;
	private CampoFormularioIntSAFC campoLongitude = null;
	private boolean convertido  =false;

	public CampoPosicaoGeografica(OperadorObjetosAbstratoSAFC operador, CampoFormularioIntSAFC campoLatitude,CampoFormularioIntSAFC campoLongitude) {
		super(operador, null, TIPO_TEXTO);
		this.campoLatitude = campoLatitude;
		this.campoLongitude = campoLongitude;
	}

	@Override
	public String getCodigo() {
		if(!convertido){
			
			script = StringManager.stringReplace("NM.this.campoLatitude", script, campoLatitude.getNome());
			script = StringManager.stringReplace("NM.this.campoLongitude", script, campoLongitude.getNome());
			
			convertido = true;
		}
		return script;
	}

	@Override
	public void setObjetoNegocio(ObjetoNegocio objetoNegocio) {
		super.setObjetoNegocio(objetoNegocio);
		
	}

	private String script = 
			"<div id=\"map_canvas\" style=\"width: 600px; height: 350px;\">map div</div>"+
			"<link href=\"/maps/documentation/javascript/examples/default.css\""+
					"	rel=\"stylesheet\">"+
					"<script"+
					"	src=\"https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false\"></script>"+
					"<script>"+
					//"-27.602164&lon=-48.52091
					"  var latt = -27.602164;"+
					"  var logn = -48.52091;"+
					"  try{"+
					"    var latP = parseInt(document.getElementById('NM.this.campoLatitude').value,10)/10000000;"+
					"    if(latP!=0){"+
					"    	latt = latP;"+
					"    }"+
					"  }catch(err){}"+
					"  try{ "+
					"	  lognP = parseInt(document.getElementById('NM.this.campoLongitude').value,10)/10000000;"+
					"	   if(lognP!=0){"+
					"	   	logn = lognP;"+
					"	   }"+
					"  }catch(err){}"+
					//"      var stockholm = new google.maps.LatLng(59.32522, 18.07002);"+
					"     var ponto = new google.maps.LatLng(latt, logn);"+
					"     var marker;"+
					"     var map;  "+


"      function initialize() {"+
"        var mapOptions = {"+
"          zoom: 13,"+
"          mapTypeId: google.maps.MapTypeId.ROADMAP,"+
"          center: ponto"+
"        };"+

"        map = new google.maps.Map(document.getElementById('map_canvas'),"+
"                mapOptions);"+
"        marker = new google.maps.Marker({"+
"          map:map,"+
"          draggable:true,"+
"          animation: google.maps.Animation.DROP,"+
"          position: ponto"+
"        });"+
"        google.maps.event.addListener(marker, 'click', toggleBounce);"+
"        google.maps.event.addListener(marker, 'mouseup', mUP);"+
"      }"+

"      function toggleBounce() {"+
"        if (marker.getAnimation() != null) {"+
"          marker.setAnimation(null);"+
"        } else {"+
"          marker.setAnimation(google.maps.Animation.BOUNCE);"+
"        }"+
"      }"+
"      function mUP(){"+
"		document.getElementById('NM.this.campoLatitude').value =  toInt(marker.position.lat()*10000000);"+
"		document.getElementById('NM.this.campoLongitude').value =  toInt(marker.position.lng()*10000000);"+
"     }"+

"    function toInt(vi){"+
"    	return parseInt(vi,10); "+  	
"    }"+
""+
""+
"    function addOnLoad(fn){ "+
"       var old = window.onload;"+
"       if(old==null){"+
"    	    window.onload = function(){"+
"        		  fn();"+
"      	};"+
"       }else{"+
"   	    window.onload = function(){"+
"      	     old();"+
"         		  fn();"+
"       	};"+
"       }"+
"    }"+
"    addOnLoad(initialize);"+

 "   </script>";





}
