import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Materia {

	Turno turno
	String descripcion

	new ( String descripcion , Turno turno ){
	this.turno = turno
	this.descripcion = descripcion
	}
}