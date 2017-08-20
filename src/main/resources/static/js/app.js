 var app = angular.module("appCliente",['ngRoute']);

 app.config(function($routeProvider){
	
	 $routeProvider
	 .when("/clientes",{templateURL:'../../view/cliente.html', controller:'clienteController'})
	 .otherwise({rediretTo:'/'});
 });

