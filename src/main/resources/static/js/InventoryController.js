
myApp.controller('InventoryController',  function($scope,$http,$window,$log,$localStorage,$sessionStorage) {
 
    var items = [];
    var price = [];
    var itemList;
    $scope.snack={ 
                   id:'',      
                   item: '',
                   price : '',
                   type : '',
                   available : ''                    
               }; 
    $scope.count = 0;
        $scope.cart={ 
                id:'',      
                item: '',
                price : '',
                type : '',
                available : ''              
            }; 
   

  /*  $scope.snack.id = 1;
    $scope.snack.item = "tiki";
    $scope.snack.stock = 5;
    $scope.snack.type = "chocolate";
    $scope.snack.selected = 100.0;
    
  */  
    
  /*
    SharedCart.changeItemId($scope.snack.id);
    SharedCart.changeItemName($scope.snack.item);
    SharedCart.changeItemQuantity($scope.snack.available);
    SharedCart.changeItemType($scope.snack.type);
    SharedCart.changeItemPrice($scope.snack.price);

  */



$window.onload = function () {
                    $http({
                        method:'GET',
                            url:'/api/inventory/all'
                        })
                            .then(function(response)
                            {
                                    $scope.snacks= response.data;
                                    //$log.info(response);
                                    
                            })};

        $scope.addSnack= function (){$http({
            method:'POST',
            url:'/api/inventory/add',
            data: $scope.snack
                }).then(function(response)
                        {})};


/*
$scope.addSnack= function (){
      var id = SharedCart.getItemId();
    var item = SharedCart.getItemName();
    var price = SharedCart.getItemPrice();
    var type = SharedCart.getItemType();     
    var stock = SharedCart.getItemStock();    
               
    $scope.snack.id = id;
    $scope.snack.item = item;
    $scope.snack.price = price;
    $scope.snack.type = type;     
    $scope.snack.stock = stock;    
   return $scope.cart;                
   
    $http({
        method:'POST',
        url:'/api/inventory/add',
		data: $scope.snack
			}).then(function(response)
					{
			    console.log($scope.snack);
					})};
*/
/*
  $scope.addCart= function ()
  {
      $scope.snack.selected  = false;         
        return $scope.snack;
    };
					*/

$scope.updateSnack=function (a) {$http({
                    method:'PUT',
                    url:'/api/snack/' + $scope.snack.id,
                    data: $scope.snack
                    
                        }).then(function(response)
                    {})};
                    

$scope.getSnack = function (a) {        
                    $http({
                        method:'GET',
                        url:'/api/inventory/'+ $scope.snack.id,
                        data: $scope.snack
                        }).then(function(response)
                            {
                              $scope.snack= response.data;   
                                                            
                          /*    SharedCart.removeItemId();
                              SharedCart.removeItemName();
                              SharedCart.removeItemQuantity();
                              SharedCart.removeItemType();
                              SharedCart.removeItemPrice();
                              
                              
                              SharedCart.changeItemId($scope.snack.id);
                              SharedCart.changeItemName($scope.snack.item);                              
                              SharedCart.changeItemStock($scope.snack.stock);
                              SharedCart.changeItemType($scope.snack.type);
                              SharedCart.changeItemPrice($scope.snack.price);
                                                */            
                                    //$log.info(response);
                              console.log($scope.snack);
                             
                            })};


                    
$scope.deleteSnack=function (a) {$http({
                    method:'DELETE',
                    url:'/api/snack/' + snack.id,
                  //  data: $scope.snack
                    
                        }).then(function(response)
                    {})};
    
                    
$scope.depleteSnack =  function (a) {$http({
                        method:'PUT',
                        url:'/api/snack/' + snack.id,
                        data: $scope.cart                        
                            }).then(function(response)
                            { 
                                $scope.snack.available = $scope.snack.available - a; 
                            })};               

 
    
    $scope.addCart= function (){

        
        if(localStorage.getItem('item') != null){
            $scope.snack.item = JSON.parse(localStorage.getItem('item'));          
         }
        if(localStorage.getItem('price') != null){
            $scope.snack.price = JSON.parse(localStorage.getItem('price'));          
         }
        if(localStorage.getItem('id') != null){
            $scope.snack.id = JSON.parse(localStorage.getItem('id'));          
         }
        
        $http({
            method:'POST',
            url:'/api/cart/add',
            data: $scope.snack
                }).then(function(response)
                        {                               
                 
                    items.push($scope.snack.item);
                    price.push($scope.snack.price);
                    itemList = items.join();                                                               
                                                          
                    
                    //orders
                    localStorage.removeItem("c_id");
                    localStorage.removeItem("cartItem");
                    localStorage.removeItem("cartPrice");
                    
                    localStorage.removeItem("c_id");
                    localStorage.removeItem("cartItem");
                    localStorage.removeItem("cartPrice");
                    
                    localStorage.setItem("cartItem", JSON.stringify(itemList));                                                            
                    localStorage.setItem("cartPrice", JSON.stringify(price));
                  localStorage.setItem("c_id", JSON.stringify($scope.cart.id));
                        })};


    
$scope.getCart = function (a) {                                                                                    
    $http({
        method:'GET',
        url:'/api/inventory/'+ $scope.snack.id,
    })
        .then(function(response)
        {
            $scope.snack= response.data;                                                                     
            
                
            //cart
            localStorage.setItem("item", JSON.stringify($scope.snack.item));
            localStorage.setItem("price", JSON.stringify($scope.snack.price));
         //  localStorage.setItem("id", JSON.stringify($scope.snack.id));
            console.log($scope.snack);
                            })}; 

                        	
                            
                            
    $scope.allCarts = function () {               
        $http({
            method:'GET',
                url:'/api/cart/all'
            })
                .then(function(response)
                {
                        $scope.carts= response.data;
                        console.log($scope.carts);
                        //$log.info(response);
                                        
                                })};
                                       
                                        
                                $scope.remove = function (a) {      
                                	
                                    
                                	
                                	
                                    $http({
                                        method:'DELETE',
                                    url:'/api/cart/' + $scope.cart.id                
                                    }).then(function(response)
                                        {                        
                                        })
                    
                                        
                       
                        };               
                                    
                          
                                        
   
});