var myApp = angular.module('myApp',[]);

myApp.controller('DoubleController',  function($scope,$http,$log) {
 
  $scope.show = function () {$http({
		  method:'GET',
			  url:'/api/cab/all'})
			  .then(function(response)
			  {
	  	$scope.employee= response.data;
	  	$log.info(response);
			  })};
  
		  
  
});