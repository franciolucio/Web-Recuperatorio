import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.XTRest;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;

@Controller
@SuppressWarnings("all")
public class ResponderController extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  @Get("/carreras")
  public Result carreras(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field RepoCarrera is undefined for the type ResponderController"
      + "\ninstance cannot be resolved"
      + "\nallCarreras cannot be resolved"
      + "\ntoJson cannot be resolved");
  }
  
  @Get("/turnos")
  public Result turnos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field RepoCarrera is undefined for the type ResponderController"
      + "\ninstance cannot be resolved"
      + "\nallTurnos cannot be resolved"
      + "\ntoJson cannot be resolved");
  }
  
  @Post("/responder")
  public Result responder(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    throw new Error("Unresolved compilation problems:"
      + "\nRespuesta cannot be resolved to a type."
      + "\nCarrera cannot be resolved to a type."
      + "\nEncuesta cannot be resolved to a type."
      + "\nThe method or field Respuesta is undefined for the type ResponderController"
      + "\nThe method or field RepoCarrera is undefined for the type ResponderController"
      + "\nErrorEnLaRespuesta cannot be resolved."
      + "\nThe method or field RepoEncuesta is undefined for the type ResponderController"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\ninstance cannot be resolved"
      + "\nfindCarrera cannot be resolved"
      + "\ncarreraId cannot be resolved"
      + "\nmaterias cannot be resolved"
      + "\nforall cannot be resolved"
      + "\ntieneEnPlanDeEstudio cannot be resolved"
      + "\n! cannot be resolved"
      + "\ngenerarEncuesta cannot be resolved"
      + "\ninstance cannot be resolved"
      + "\nagregarRespuesta cannot be resolved"
      + "\nmail cannot be resolved");
  }
  
  public static void main(final String[] args) {
    XTRest.start(ResponderController.class, 9200);
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
    		Pattern.compile("/responder").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = responder(body, target, baseRequest, request, response);
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
    	+ "				<td>POST</td>"
    	+ "				<td>/responder</td>"
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
