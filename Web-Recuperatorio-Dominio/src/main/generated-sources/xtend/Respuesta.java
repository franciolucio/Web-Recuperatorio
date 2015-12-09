import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Respuesta {
  private Carrera carrera;
  
  private List<Materia> materiasACursar;
  
  private Integer anioIngreso;
  
  private Integer finalesAprobados;
  
  private Integer finalesDesaprobados;
  
  private Integer cursadasAprobadas;
  
  private String mailDelEncuestado;
  
  public Respuesta() {
  }
  
  public Respuesta(final Carrera carrera, final Integer anioIngreso, final Integer finalesAprobados, final Integer finalesDesaprobados, final Integer cursadasAprobadas, final String mailDelEncuestado, final List<Materia> materiasACursar) {
    this.carrera = carrera;
    this.anioIngreso = anioIngreso;
    this.finalesAprobados = finalesAprobados;
    this.finalesDesaprobados = finalesDesaprobados;
    this.cursadasAprobadas = cursadasAprobadas;
    this.materiasACursar = materiasACursar;
    this.mailDelEncuestado = mailDelEncuestado;
  }
  
  public void validar() {
    try {
      boolean _or = false;
      boolean _or_1 = false;
      boolean _or_2 = false;
      boolean _or_3 = false;
      boolean _equals = Objects.equal(this.carrera, null);
      if (_equals) {
        _or_3 = true;
      } else {
        boolean _equals_1 = Objects.equal(this.anioIngreso, null);
        _or_3 = _equals_1;
      }
      if (_or_3) {
        _or_2 = true;
      } else {
        boolean _equals_2 = Objects.equal(this.finalesAprobados, null);
        _or_2 = _equals_2;
      }
      if (_or_2) {
        _or_1 = true;
      } else {
        boolean _equals_3 = Objects.equal(this.finalesDesaprobados, null);
        _or_1 = _equals_3;
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _equals_4 = Objects.equal(this.cursadasAprobadas, null);
        _or = _equals_4;
      }
      if (_or) {
        throw new RespuestaException();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public Carrera getCarrera() {
    return this.carrera;
  }
  
  public void setCarrera(final Carrera carrera) {
    this.carrera = carrera;
  }
  
  @Pure
  public List<Materia> getMateriasACursar() {
    return this.materiasACursar;
  }
  
  public void setMateriasACursar(final List<Materia> materiasACursar) {
    this.materiasACursar = materiasACursar;
  }
  
  @Pure
  public Integer getAnioIngreso() {
    return this.anioIngreso;
  }
  
  public void setAnioIngreso(final Integer anioIngreso) {
    this.anioIngreso = anioIngreso;
  }
  
  @Pure
  public Integer getFinalesAprobados() {
    return this.finalesAprobados;
  }
  
  public void setFinalesAprobados(final Integer finalesAprobados) {
    this.finalesAprobados = finalesAprobados;
  }
  
  @Pure
  public Integer getFinalesDesaprobados() {
    return this.finalesDesaprobados;
  }
  
  public void setFinalesDesaprobados(final Integer finalesDesaprobados) {
    this.finalesDesaprobados = finalesDesaprobados;
  }
  
  @Pure
  public Integer getCursadasAprobadas() {
    return this.cursadasAprobadas;
  }
  
  public void setCursadasAprobadas(final Integer cursadasAprobadas) {
    this.cursadasAprobadas = cursadasAprobadas;
  }
  
  @Pure
  public String getMailDelEncuestado() {
    return this.mailDelEncuestado;
  }
  
  public void setMailDelEncuestado(final String mailDelEncuestado) {
    this.mailDelEncuestado = mailDelEncuestado;
  }
}
