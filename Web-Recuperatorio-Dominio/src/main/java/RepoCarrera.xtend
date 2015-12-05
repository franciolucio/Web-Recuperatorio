import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class RepoCarrera {
	
	List<Carrera> carreras
	List<Turno> turnos
	Carrera carrera01
	Materia materia01
	Materia materia02
	
	new () {
		carrera01 = new Carrera("Tecnicatura en Programacion Informatica")
		materia01 = new Materia("Matematica 1", Turno.NOCHE)
		materia02 = new Materia("Matematica 2", Turno.TARDE)
		
		carrera01.materias = #[materia01,materia02]
		carreras = #[carrera01]
		turnos = #[Turno.MANIANA,Turno.TARDE,Turno.NOCHE]
		
	}
}