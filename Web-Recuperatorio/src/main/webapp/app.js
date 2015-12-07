var app = angular . module ( 'encuestaApp' , [ 'ngRoute' ]);

app.config ( function ( $routeProvider ) {

	$routeProvider
	.when ( '/' , { templateUrl : 'login.html' , controller : 'LoginCtrl' })
	.when ( '/responder/:mail' , { templateUrl : 'responder.html' , controller :
			'ResponderCtrl' })
	.when ( '/gracias' , { templateUrl : 'gracias.html' })
	.otherwise ({ redirectTo : '/' });
});

app.service ('EncuestaService' , function ( $http ) {
	return {
		responderEncuesta : function ( respuesta , callback ) {
		$http.get('/responder',respuesta).success(callback );
		},
		getCarreras : function (){
			$http.get('/carreras').then(callback);
		},
		getTurnos : function (callback){
			$http.get('/turnos').then(callback);
		}
	}
});

app.controller ( 'LoginCtrl' , function ( $location ) {
		$scope . autenticar = function (){
			$location . path ( 'responder/' + $scope . user . mail );
	}
});

app.controller ( 'ResponderCtrl' , function ( $scope , $location , $routeParams , EncuestaService ){

	$scope.turnos = EncuestaService.getTurnos();
	$scope.carreras = EncuestaService .getCarreras();
	$scope.respuesta = { mail : $routeParams . mail , materias : []};
	$scope.agregarMateria = function (){
	$scope.respuesta.materias.push({ materia : $scope . materiaSeleccionada , turno :
	$scope.turnoSeleccionado });
	$scope.materiaSeleccionada = {};
	$scope.turnoSeleccionado = {};
	}

	$scope.contestar = function () {
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