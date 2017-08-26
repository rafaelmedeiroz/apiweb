 var app = angular.module("appCliente",['ngRoute']);

 app.config(function($routeProvider, $locationProvider)
{
	
	 $routeProvider
	 .when("/clientes",
		{templateUrl:'view/cliente.html', 
		 controller:'clienteController'})
	 .when("/cidades",
		{templateUrl:'view/cidade.html', 
		 controller:'cidadeController'})
	 .when("/estados",
		{templateUrl:'view/estado.html', 
		 controller:'estadoController'})
	 .when("/clientes/:clienteId",
		{templateUrl:'view/clientedetalhe.html', 
		 controller:'clienteDetalheController'})
	 .otherwise({rediretTo:'/'});
	 
	 $locationProvider.html5Mode(true);
 });

