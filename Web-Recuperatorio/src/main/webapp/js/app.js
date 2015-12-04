var app = angular . module ( 'encuestaApp' , [ 'ngRoute' ]);
app . config ( function ( $routeProvider ) {
	$routeProvider . when ( '/' , { templateUrl : 'pages/login.html' , controller : 'LoginCtrl' })
	.when ( '/responder/:mail' , { templateUrl : 'pages/responder.html' , controller :'ResponderCtrl' })
	.when ( '/gracias' , { templateUrl : 'pages/gracias.html' })
	.otherwise ({ redirectTo : '/' });
});

app.service ( 'EncuestaService' , function ( $http ) {
	return {
		responderEncuesta : function ( respuesta , callback ) {
		$http . get ( '/responder' , respuesta ). success ( callback );
		},
		getCarreras : function (){
		//obtiene la lista de carreras con el detalle de las materias y lo devuelve
		},
		getTurnos : function (){
		//obtiene la lista de turnos y lo devuelve
		}
	}
});

app.controller ( 'LoginCtrl' , function ( $location ) {

	$scope . autenticar = function (){
	$location . path ( 'responder/' + $scope . user . mail );
	}
});

app.controller ( 'ResponderCtrl' , function ( $scope , $location , $routeParams , EncuestaService ){

	$scope . turnos = EncuestaService . getTurnos ();
	$scope . carreras = EncuestaService . getCarreras ();
	$scope . respuesta = { mail : $routeParams . mail , materias : []};
	$scope . agregarMateria = function (){
	$scope . respuesta . materias . push ({ materia : $scope . materiaSeleccionada , turno :
	$scope . turnoSeleccionado });
	$scope . materiaSeleccionada = {};
	$scope . turnoSeleccionado = {};
	}

	$scope . contestar = function () {
	//Checkeamos los campos obligatorios
	if ( $scope . respuesta . materias . length <= 0 ){
		alert ( 'Debe ingresar materias para continuar' );
		return;
	}

	if (! $scope . carreraSeleccionada ){
		alert ( 'Debe seleccionar una carrera' );
		return;
	}

	if (! $scope . respuesta . anioIngreso ){
		alert ( 'Debe indicar el año de ingreso a la facultad' );
	return;
	}

	//Todo OK, impactamos en el server
		$scope . respuesta . carreraId = $scope . carreraSeleccionada . id;
		EncuestaService . responderEncuesta ( $scope . respuesta , function ( data ){
		$location . path ( 'gracias' );
		});
	}
});