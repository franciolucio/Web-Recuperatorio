import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.XTRest;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
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
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
