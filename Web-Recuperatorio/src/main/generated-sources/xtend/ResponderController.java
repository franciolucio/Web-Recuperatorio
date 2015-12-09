import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.XTRest;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;

@Controller
@SuppressWarnings("all")
public class ResponderController extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  @Get("/carreras")
  public Result carreras(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      RepoCarrera _repoCarrera = new RepoCarrera();
      List<Carrera> _carreras = _repoCarrera.getCarreras();
      final Carrera[] carreras = ((Carrera[])Conversions.unwrapArray(_carreras, Carrera.class)).clone();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(carreras);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/turnos")
  public Result turnos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      RepoCarrera _repoCarrera = new RepoCarrera();
      List<Turno> _turnos = _repoCarrera.getTurnos();
      final Turno[] turnos = ((Turno[])Conversions.unwrapArray(_turnos, Turno.class)).clone();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(turnos);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/carrera")
  public Result carrera(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      RepoCarrera _repoCarrera = new RepoCarrera();
      final Carrera carrera = _repoCarrera.getCarrera01();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(carrera);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/respuestas")
  public Result respuestas(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      RepoEncuesta _repoEncuesta = new RepoEncuesta();
      final List<Respuesta> respuestas = _repoEncuesta.getRespuestas();
      response.setContentType(ContentType.APPLICATION_JSON);
      String _json = this._jSONUtils.toJson(respuestas);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Post("/answers")
  public Result agregarRespuesta(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    try {
      Result _xblockexpression = null;
      {
        response.setContentType(ContentType.APPLICATION_JSON);
        Result _xtrycatchfinallyexpression = null;
        try {
          Result _xblockexpression_1 = null;
          {
            Respuesta nuevaRespuesta = this._jSONUtils.<Respuesta>fromJson(body, Respuesta.class);
            nuevaRespuesta.validar();
            RepoEncuesta _repoEncuesta = new RepoEncuesta();
            Carrera _carrera = nuevaRespuesta.getCarrera();
            Integer _anioIngreso = nuevaRespuesta.getAnioIngreso();
            Integer _finalesAprobados = nuevaRespuesta.getFinalesAprobados();
            Integer _finalesDesaprobados = nuevaRespuesta.getFinalesDesaprobados();
            Integer _cursadasAprobadas = nuevaRespuesta.getCursadasAprobadas();
            String _mailDelEncuestado = nuevaRespuesta.getMailDelEncuestado();
            List<Materia> _materiasACursar = nuevaRespuesta.getMateriasACursar();
            Respuesta _agregarRespuesta = _repoEncuesta.agregarRespuesta(_carrera, _anioIngreso, _finalesAprobados, _finalesDesaprobados, _cursadasAprobadas, _mailDelEncuestado, _materiasACursar);
            nuevaRespuesta = _agregarRespuesta;
            String _json = this._jSONUtils.toJson(nuevaRespuesta);
            _xblockexpression_1 = ResultFactory.ok(_json);
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } catch (final Throwable _t) {
          if (_t instanceof RespuestaException) {
            final RespuestaException e = (RespuestaException)_t;
            throw new RespuestaException();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * @Post ( '/responder')
   * def Result responder ( @Body String body ) {
   * var Respuesta respuesta = body.fromJson(Respuesta)
   * val Carrera carrera = RepoCarrera.instance.findCarrera(respuesta.carreraId)
   * if (! respuesta.materiasACursar.forall[materia|carrera.tieneEnPlanDeEstudio(materia)]){
   * throw new ErrorEnLaRespuesta
   * }
   * var Encuesta encuesta = respuesta.generarEncuesta ();
   * RepoEncuesta.instance.agregarRespuesta(respuesta.mail , encuesta)
   * ok ();
   * }
   */
  public static void main(final String[] args) {
    XTRest.start(ResponderController.class, 9000);
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/carreras").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = carreras(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/turnos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = turnos(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/carrera").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = carrera(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/respuestas").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = respuestas(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/answers").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = agregarRespuesta(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    this.pageNotFound(baseRequest, request, response);
  }
  
  public void pageNotFound(final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    response.getWriter().write(
    	"<html><head><title>XtRest - Page Not Found!</title></head>" 
    	+ "<body>"
    	+ "	<h1>Page Not Found !</h1>"
    	+ "	Supported resources:"
    	+ "	<table>"
    	+ "		<thead><tr><th>Verb</th><th>URL</th><th>Parameters</th></tr></thead>"
    	+ "		<tbody>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/carreras</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/turnos</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/carrera</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/respuestas</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/answers</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
