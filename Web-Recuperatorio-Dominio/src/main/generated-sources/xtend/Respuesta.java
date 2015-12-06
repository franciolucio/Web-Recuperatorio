import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Respuesta {
  private Carrera carrera;
  
  private List<Materia> materiasACursar;
  
  private Date añoDeIngreso;
  
  private Integer finalesAprobados;
  
  private Integer finalesDesaprobados;
  
  private Integer cursadasAprobadas;
  
  private String mailDelEncuestado;
  
  public Respuesta() {
    ArrayList<Materia> _newArrayList = CollectionLiterals.<Materia>newArrayList();
    this.materiasACursar = _newArrayList;
  }
  
  public boolean agregarMateriaACursar(final String nombreDeMateria, final Turno turno) {
    try {
      boolean _xifexpression = false;
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(nombreDeMateria, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(turno, null));
        _and = _notEquals_1;
      }
      if (_and) {
        Materia _materia = new Materia(nombreDeMateria, turno);
        _xifexpression = this.materiasACursar.add(_materia);
      } else {
        throw new ErrorAlNoCompletarCampo();
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public boolean isEsValida() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _notEquals = (!Objects.equal(this.carrera, null));
    if (!_notEquals) {
      _and_2 = false;
    } else {
      boolean _validarCantidadDeCarreras = this.validarCantidadDeCarreras();
      _and_2 = _validarCantidadDeCarreras;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.añoDeIngreso, null));
      _and_1 = _notEquals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _mailValido = this.mailValido(this.mailDelEncuestado);
      _and = _mailValido;
    }
    return _and;
  }
  
  private boolean validarCantidadDeCarreras() {
    int _size = this.materiasACursar.size();
    return (_size > 1);
  }
  
  private boolean mailValido(final String email) {
    boolean _xblockexpression = false;
    {
      Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
      Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
      _xblockexpression = matcher.find();
    }
    return _xblockexpression;
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
  public Date getAñoDeIngreso() {
    return this.añoDeIngreso;
  }
  
  public void setAñoDeIngreso(final Date añoDeIngreso) {
    this.añoDeIngreso = añoDeIngreso;
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
