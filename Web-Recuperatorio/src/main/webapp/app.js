var app = angular.module('app',['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise("/login");
	
	$stateProvider.state('login',{
		    url: '/login',
		    templateUrl: 'login.html',
		    controller: 'LoginCtrl'
		  });
	$stateProvider.state('responder',{
		    url: '/responder',
		    controller: 'ResponderCtrl',
		    templateUrl: 'responder.html'
		  });
	$stateProvider.state('gracias',{
		    url: '/gracias',
		    controller: 'ResponderCtrl',
		    templateUrl: 'gracias.html'
		  });
});

//		responderEncuesta:function(respuesta,callback){
//		$http.get('/responder',respuesta).success(callback);
//		},

app.controller('LoginCtrl',['$state','$http','$scope',function($state,$http,$scope){
		
		$scope.autenticar=function(){
			$state.go('responder');
	}
}]);

app.controller('ResponderCtrl',['$state','$http','$scope',function($state,$http,$scope){

	$http.get('carreras').success(function(response){
		$scope.carreras = response;
	});
	
	$http.get('turnos').success(function(response){
		$scope.turnos = response;
	});
	
	$scope.respuesta={materias:[]};
	$scope.agregarMateria=function(){
	$scope.respuesta.materias.push({materia:$scope.materiaSeleccionada,turno:
	$scope.turnoSeleccionado});
	$scope.materiaSeleccionada={};
	$scope.turnoSeleccionado={};
	}

	$scope.contestar=function(){
	//Checkeamos los campos obligatorios
	if($scope.respuesta.materias.length<= 0){
		alert('Debe ingresar materias para continuar');
		return;
	}

	if(!$scope.carreraSeleccionada){
		alert('Debe seleccionar una carrera');
		return;
	}

	if(!$scope.respuesta.anioIngreso){
		alert('Debe indicar el año de ingreso a la facultad');
	return;
	}

	//Todo OK, impactamos en el server
		$scope.respuesta.carreraId=$scope.carreraSeleccionada.id;
		$state.go('gracias');
	}
}]);