@SuppressWarnings("all")
public class ErrorEnLaRespuesta extends Exception {
  public ErrorEnLaRespuesta() {
    super("No puede mezclar materias de distintas carreras");
  }
}
