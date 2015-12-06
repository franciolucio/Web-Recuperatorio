import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Encuesta {
  private List<Materia> materias;
  
  private String carreraSeleccionada;
  
  private String anioIngreso;
  
  private String finalesAprobados;
  
  private String finalesDesaprobados;
  
  private String cursadasAprobadas;
  
  private Turno turnoSeleccionado;
  
  private String materiaSeleccionada;
  
  public Encuesta() {
    ArrayList<Materia> _newArrayList = CollectionLiterals.<Materia>newArrayList();
    this.materias = _newArrayList;
  }
  
  public boolean agregarMateriaSeleccionada() {
    boolean _xblockexpression = false;
    {
      Materia materia = new Materia(this.materiaSeleccionada, this.turnoSeleccionado);
      _xblockexpression = this.materias.add(materia);
    }
    return _xblockexpression;
  }
  
  public List<String> getCarrerasPosibles() {
    return IterableExtensions.<String>toList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Sistemas - K", "Electronica - Q", "Industrial - Z")));
  }
  
  public List<String> getMateriasPosibles() {
    return IterableExtensions.<String>toList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Discreta", "Algebra", "Ingenieria y Sociedad", "Matematica Superior", "Paradigmas de Programacion", "Algoritmos", "Sintaxis", "Resistencias de\r\n\t\t  Materiales")));
  }
  
  public List<Turno> getTurnosPosibles() {
    Turno[] _values = Turno.values();
    return IterableExtensions.<Turno>toList(((Iterable<Turno>)Conversions.doWrapArray(_values)));
  }
  
  public List<String> getDescripcionMaterias() {
    final Function1<Materia, String> _function = new Function1<Materia, String>() {
      public String apply(final Materia it) {
        StringConcatenation _builder = new StringConcatenation();
        String _descripcion = it.getDescripcion();
        _builder.append(_descripcion, "");
        _builder.append(" (");
        Turno _turno = it.getTurno();
        String _name = _turno.name();
        _builder.append(_name, "");
        _builder.append(")");
        return _builder.toString();
      }
    };
    List<String> _map = ListExtensions.<Materia, String>map(this.materias, _function);
    return IterableExtensions.<String>toList(_map);
  }
  
  @Pure
  public List<Materia> getMaterias() {
    return this.materias;
  }
  
  public void setMaterias(final List<Materia> materias) {
    this.materias = materias;
  }
  
  @Pure
  public String getCarreraSeleccionada() {
    return this.carreraSeleccionada;
  }
  
  public void setCarreraSeleccionada(final String carreraSeleccionada) {
    this.carreraSeleccionada = carreraSeleccionada;
  }
  
  @Pure
  public String getAnioIngreso() {
    return this.anioIngreso;
  }
  
  public void setAnioIngreso(final String anioIngreso) {
    this.anioIngreso = anioIngreso;
  }
  
  @Pure
  public String getFinalesAprobados() {
    return this.finalesAprobados;
  }
  
  public void setFinalesAprobados(final String finalesAprobados) {
    this.finalesAprobados = finalesAprobados;
  }
  
  @Pure
  public String getFinalesDesaprobados() {
    return this.finalesDesaprobados;
  }
  
  public void setFinalesDesaprobados(final String finalesDesaprobados) {
    this.finalesDesaprobados = finalesDesaprobados;
  }
  
  @Pure
  public String getCursadasAprobadas() {
    return this.cursadasAprobadas;
  }
  
  public void setCursadasAprobadas(final String cursadasAprobadas) {
    this.cursadasAprobadas = cursadasAprobadas;
  }
  
  @Pure
  public Turno getTurnoSeleccionado() {
    return this.turnoSeleccionado;
  }
  
  public void setTurnoSeleccionado(final Turno turnoSeleccionado) {
    this.turnoSeleccionado = turnoSeleccionado;
  }
  
  @Pure
  public String getMateriaSeleccionada() {
    return this.materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final String materiaSeleccionada) {
    this.materiaSeleccionada = materiaSeleccionada;
  }
}
