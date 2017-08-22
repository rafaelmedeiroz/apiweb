 var app = angular.module("appCliente",['ngRoute']);

 app.config(function($routeProvider)
{
	
	 $routeProvider
	 .when("/clientes",{templateUrl:'view/cliente.html', controller:'clienteController'})
	 .otherwise({rediretTo:'/'});
 });

