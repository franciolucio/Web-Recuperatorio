import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Carrera {
  private String nombre;
  
  private List<Materia> materias;
  
  public Carrera(final String nombre) {
    this.nombre = nombre;
    ArrayList<Materia> _newArrayList = CollectionLiterals.<Materia>newArrayList();
    this.materias = _newArrayList;
  }
  
  public Carrera(final String nombre, final List<Materia> materias) {
    this.nombre = nombre;
    this.materias = materias;
  }
  
  public boolean agregarMateria(final Materia materia) {
    return this.materias.add(materia);
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public List<Materia> getMaterias() {
    return this.materias;
  }
  
  public void setMaterias(final List<Materia> materias) {
    this.materias = materias;
  }
}
