
myApp.controller('OrderController',  function($scope,$http,$log,$window,$localStorage,$sessionStorage) {
 



	$window.onload = function () {
	    $http({
	        method:'GET',
	            url:'/api/order/all'
	        })
	            .then(function(response)
	            {
	                    $scope.orders= response.data;
	                    console.log($scope.orders);
	            })};



	
$scope.orderPick = 0;				  



$scope.addOrder= function (){$http({
        method:'POST',
        url:'/api/order/add',
		data: $scope.order
			}).then(function(response)
                    {
		        console.log($scope.order);
                    })};
                    

                    
$scope.getOrder = function (a) {$http({       
                    method:'GET',
                    url:'/api/order/' + order.id,
                    })
                        .then(function(response)
                        {
                                $scope.order= response.data;
                                //$log.info(response);
                        })};
    

                            
$scope.updateOrder=function (a) {$http({
                    method:'PUT',
                    url:'/api/order/' + order.id,
                    data: $scope.order
                    
                        }).then(function(response)
                    {})};
                    

$scope.deleteOrder=function (a) {$http({
                    method:'DELETE',
                    url:'/api/order/' + order.id,
                    data: $scope.order
                    
                        }).then(function(response)
                    {})};
                    

                    

});


           