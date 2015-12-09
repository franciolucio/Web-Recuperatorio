import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Materia {
  private Turno turno;
  
  private String descripcion;
  
  public Materia() {
  }
  
  public Materia(final String descripcion, final Turno turno) {
    this.turno = turno;
    this.descripcion = descripcion;
  }
  
  @Pure
  public Turno getTurno() {
    return this.turno;
  }
  
  public void setTurno(final Turno turno) {
    this.turno = turno;
  }
  
  @Pure
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this.descripcion = descripcion;
  }
}
