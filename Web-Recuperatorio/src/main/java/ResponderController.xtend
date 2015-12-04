import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils

@Controller
class ResponderController {

extension JSONUtils = new JSONUtils
	
	@Get ( '/carreras')
	def Result carreras (){
	response . contentType = ContentType . APPLICATION_JSON
	ok ( RepoCarrera . instance . allCarreras . toJson)
	}

	@Get ( '/turnos')
	def Result turnos (){
	response . contentType = ContentType . APPLICATION_JSON
	ok ( RepoCarrera . instance . allTurnos . toJson)
	}

	@Post ( '/responder')
	def Result responder ( @Body String body ) {
	var Respuesta respuesta = body . fromJson ( Respuesta)
	val Carrera carrera = RepoCarrera . instance . findCarrera ( respuesta . carreraId)
	if (! respuesta . materias . forall [ materia | carrera . tieneEnPlanDeEstudio ( materia )] ){
	throw new ErrorEnLaRespuesta ( "No puede mezclar materias de distintas carreras")
	}
	var Encuesta encuesta = respuesta . generarEncuesta ();
	RepoEncuesta . instance . agregarRespuesta ( respuesta . mail , encuesta)
	ok ();
	}

	def static void main ( String [] args ) {
	XTRest . start ( ResponderController , 9200)
	}
}
