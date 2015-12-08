import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils

@Controller
class ResponderController {

extension JSONUtils = new JSONUtils
	
	@Get ('/carreras')
	def Result carreras (){
		val carreras = new RepoCarrera().carreras.clone
		response.contentType = ContentType.APPLICATION_JSON
		ok (carreras.toJson)
	}

	@Get ('/turnos')
	def Result turnos (){
		val turnos = new RepoCarrera().turnos.clone
		response . contentType = ContentType . APPLICATION_JSON
		ok(turnos.toJson)
	}
	
	@Get ('/carrera')
	def Result carrera (){
		val carrera = new RepoCarrera().carrera01
		response . contentType = ContentType . APPLICATION_JSON
		ok(carrera.toJson)
	}

	/* @Post ( '/responder')
	def Result responder ( @Body String body ) {
		var Respuesta respuesta = body.fromJson(Respuesta)
		val Carrera carrera = RepoCarrera.instance.findCarrera(respuesta.carreraId)
		if (! respuesta.materiasACursar.forall[materia|carrera.tieneEnPlanDeEstudio(materia)]){
			throw new ErrorEnLaRespuesta 
		}
		var Encuesta encuesta = respuesta.generarEncuesta ();
		RepoEncuesta.instance.agregarRespuesta(respuesta.mail , encuesta)
		ok ();
	}*/

	def static void main ( String [] args ) {
	XTRest . start ( ResponderController , 9000)
	}
}

