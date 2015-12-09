import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoEncuesta {
  private List<Respuesta> respuestas = CollectionLiterals.<Respuesta>newArrayList();
  
  private Respuesta respuesta01;
  
  private Carrera carrera01;
  
  private Materia materia01;
  
  private Materia materia02;
  
  private Materia materia03;
  
  private List<Materia> materiasACursar;
  
  public RepoEncuesta() {
    Carrera _carrera = new Carrera("Tecnicatura en Programacion Informatica");
    this.carrera01 = _carrera;
    Materia _materia = new Materia("Matematica 1", Turno.NOCHE);
    this.materia01 = _materia;
    Materia _materia_1 = new Materia("Matematica 2", Turno.TARDE);
    this.materia02 = _materia_1;
    Materia _materia_2 = new Materia("Orga", Turno.TARDE);
    this.materia03 = _materia_2;
    this.materiasACursar = Collections.<Materia>unmodifiableList(CollectionLiterals.<Materia>newArrayList(this.materia03));
    this.carrera01.setMaterias(Collections.<Materia>unmodifiableList(CollectionLiterals.<Materia>newArrayList(this.materia01, this.materia02)));
    Respuesta _respuesta = new Respuesta(this.carrera01, Integer.valueOf(2005), Integer.valueOf(10), Integer.valueOf(9), Integer.valueOf(8), "franciolucio@gmail.com", this.materiasACursar);
    this.respuesta01 = _respuesta;
    this.respuestas.add(this.respuesta01);
  }
  
  public Respuesta agregarRespuesta(final Carrera carrera, final Integer anioIngreso, final Integer finalesAprobados, final Integer finalesDesaprobados, final Integer cursadasAprobadas, final String mailDelEncuestado, final List<Materia> materiasACursar) {
    Respuesta respuesta = new Respuesta(carrera, anioIngreso, finalesAprobados, finalesDesaprobados, cursadasAprobadas, mailDelEncuestado, materiasACursar);
    this.respuestas.add(respuesta);
    return respuesta;
  }
  
  @Pure
  public List<Respuesta> getRespuestas() {
    return this.respuestas;
  }
  
  public void setRespuestas(final List<Respuesta> respuestas) {
    this.respuestas = respuestas;
  }
  
  @Pure
  public Respuesta getRespuesta01() {
    return this.respuesta01;
  }
  
  public void setRespuesta01(final Respuesta respuesta01) {
    this.respuesta01 = respuesta01;
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
  
  @Pure
  public Materia getMateria03() {
    return this.materia03;
  }
  
  public void setMateria03(final Materia materia03) {
    this.materia03 = materia03;
  }
  
  @Pure
  public List<Materia> getMateriasACursar() {
    return this.materiasACursar;
  }
  
  public void setMateriasACursar(final List<Materia> materiasACursar) {
    this.materiasACursar = materiasACursar;
  }
}
