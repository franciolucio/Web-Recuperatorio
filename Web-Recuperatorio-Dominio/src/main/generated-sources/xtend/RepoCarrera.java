import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoCarrera {
  private List<Carrera> carreras;
  
  private List<Turno> turnos;
  
  private Carrera carrera01;
  
  private Materia materia01;
  
  private Materia materia02;
  
  public RepoCarrera() {
    Carrera _carrera = new Carrera("Tecnicatura en Programacion Informatica");
    this.carrera01 = _carrera;
    Materia _materia = new Materia("Matematica 1", Turno.NOCHE);
    this.materia01 = _materia;
    Materia _materia_1 = new Materia("Matematica 2", Turno.TARDE);
    this.materia02 = _materia_1;
    this.carrera01.setMaterias(Collections.<Materia>unmodifiableList(CollectionLiterals.<Materia>newArrayList(this.materia01, this.materia02)));
    this.carreras = Collections.<Carrera>unmodifiableList(CollectionLiterals.<Carrera>newArrayList(this.carrera01));
    this.turnos = Collections.<Turno>unmodifiableList(CollectionLiterals.<Turno>newArrayList(Turno.MANIANA, Turno.TARDE, Turno.NOCHE));
  }
  
  @Pure
  public List<Carrera> getCarreras() {
    return this.carreras;
  }
  
  public void setCarreras(final List<Carrera> carreras) {
    this.carreras = carreras;
  }
  
  @Pure
  public List<Turno> getTurnos() {
    return this.turnos;
  }
  
  public void setTurnos(final List<Turno> turnos) {
    this.turnos = turnos;
  }
  
  @Pure
  public Carrera getCarrera01() {
    return this.carrera01;
  }
  
  public void setCarrera01(final Carrera carrera01) {
    this.carrera01 = carrera01;
  }
  
  @Pure
  public Materia getMateria01() {
    return this.materia01;
  }
  
  public void setMateria01(final Materia materia01) {
    this.materia01 = materia01;
  }
  
  @Pure
  public Materia getMateria02() {
    return this.materia02;
  }
  
  public void setMateria02(final Materia materia02) {
    this.materia02 = materia02;
  }
}
