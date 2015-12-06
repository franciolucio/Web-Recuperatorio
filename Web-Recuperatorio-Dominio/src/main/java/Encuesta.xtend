import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Encuesta {

	var List < Materia > materias
	var String carreraSeleccionada
	var String anioIngreso
	var String finalesAprobados
	var String finalesDesaprobados
	var String cursadasAprobadas

	//solo la usamos desde la vista
	Turno turnoSeleccionado
	String materiaSeleccionada

	new (){
	materias = newArrayList
	}

	def agregarMateriaSeleccionada() {
		var materia = new Materia(materiaSeleccionada ,turnoSeleccionado)
		materias.add ( materia)
	}

	def List <String> getCarrerasPosibles(){
		#["Sistemas - K", "Electronica - Q", "Industrial - Z"].toList
	}

	def List <String> getMateriasPosibles(){
		#["Discreta", "Algebra", "Ingenieria y Sociedad", "Matematica Superior",
		  "Paradigmas de Programacion", "Algoritmos", "Sintaxis", "Resistencias de
		  Materiales"].toList
	}

	def List <Turno> getTurnosPosibles(){
		Turno.values.toList
	}

	def List <String> getDescripcionMaterias (){
		materias.map[ '''«it.descripcion» («it.turno.name»)''' ]. toList
	}
}