import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

@Accessors
class Carrera {
	
	String nombre
	List<Materia> materias
	
	new( String nombre){
	this.nombre = nombre
	this.materias = newArrayList
	
	}
}