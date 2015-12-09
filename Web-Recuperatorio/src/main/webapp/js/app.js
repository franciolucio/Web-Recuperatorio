var app = angular.module('app',['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise("/login");
	
	$stateProvider.state('login',{
		    url: '/login',
		    templateUrl: 'templates/login.html',
		    controller: 'LoginCtrl'
		  });
	$stateProvider.state('responder',{
		    url: '/responder',
		    controller: 'ResponderCtrl',
		    templateUrl: 'templates/responder.html'
		  });
	$stateProvider.state('gracias',{
		    url: '/gracias',
		    controller: 'ResponderCtrl',
		    templateUrl: 'templates/gracias.html'
		  });
});

app.controller('LoginCtrl',['$state','$http','$scope',function($state,$http,$scope){
		
		$scope.autenticar=function(email){
			$http.get('respuestas').success(function(response){
				var respuestas = response;
				for(i = 0; i < respuestas.length; i++){
					if (email == respuestas[i].mailDelEncuestado){
						alert('Usted ya completo la encuentas. No puede volver a completarla');
						return;
					}
				}
				$state.go('responder');
			});
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
		var resp =  {	carrera:$scope.carreraSeleccionada,
			      		anioIngreso:$scope.respuesta.anioIngreso,
			      		finalesAprobados:$scope.respuesta.finalesAprobados,
			      		finalesDesaprobados:$scope.respuesta.finalesDesaprobados,
			      		cursadasAprobadas:$scope.respuesta.cursadasAprobadas,
			      		mailDelEncuestado:"lucho_boca20@hotmail.com",
				      	materiasACursar:$scope.materiaSeleccionada
			    };
		
			$http.post('/answers',resp).success(function(response){
	    		$scope.answers = response;
	    		$state.go('gracias');
	    	}).error(function() {
	    		  alert('Hay campos sin completar');
	    		  return;
	    		});
			}
}]);