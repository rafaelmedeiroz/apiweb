app.controller("clienteController", function($scope, $http){
	
	$scope.clientes=[];
	$scope.cliente={};
	//metodo carregar clientes
	carregarClientes= function(){
	$http({method: 'GET', url:'http://localhost:8080/clientes'})
	.then(function (response) {
			$scope.clientes=response.data;
		    console.log(response.status);
	}, function(response) {
		 console.log(response.status);
	 });
	}
	
	//metodo adicionar cliente
	$scope.adicionarCliente= function(cliente){
		
		$http({method: 'POST', url:'http://localhost:8080/clientes',data:cliente})
		.then(function (response) {
				 	$scope.clientes.push(response.data);
				 	delete $scope.cliente;
					carregarClientes();
		}, function(response) {
			 console.log(response.status);
		 });
		
	}
	carregarClientes();
$scope.removerCliente= function(cliente){
		$http({method: 'DELETE', url:'http://localhost:8080/clientes/'+cliente.id})
		.then(function (response) {
			
			pos= $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos,1);
		}, function(response) {
			 console.log(response.status);
		 });
		
	}
$scope.alterarCliente= function(cliente){
	$scope.cliente=angular.copy(cliente);
	
}
$scope.cancelarAlteracaoCliente = function(){
	$scope.cliente={};
};
	
});