
myApp.controller('CartController',  function($scope,$http,$log,SharedCart) {
    
    $scope.cart={ 
                   id:'',      
                   item: '',
                   price : '',
                   type: '',
                   available: ''              
               };
/*
    SharedCart.changeItemId($scope.cart.id);
    SharedCart.changeItemName($scope.cart.item);
    SharedCart.changeItemQuantity($scope.cart.quantity);
    SharedCart.changeItemPrice($scope.cart.price);
*/
  /*  $scope.cart.id = 1;
    $scope.cart.item = "new snack";
    $scope.cart.price = 100.0;
    $scope.cart.type = "sugar";  
    $scope.cart.available = 1;
  */
    

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

       $scope.addCart= function (){                      
           var id = SharedCart.getItemId();
           var item = SharedCart.getItemName();
           var price = SharedCart.getItemPrice();
           var type = SharedCart.getItemType();     
           var quantity = SharedCart.getItemQuantity();    
                      
           $scope.cart.id = id;
           $scope.cart.item = item;
           $scope.cart.price = price;
           $scope.cart.type = type;     
           $scope.cart.available = quantity;    
          return $scope.cart;                    
       $http({
           method:'POST',
           url:'/api/cart/add',
           data: $scope.cart
               }).then(function(response)
                       {                   
                   console.log($scope.cart);
                   SharedCart.removeItemId();
                   SharedCart.removeItemName();
                   SharedCart.removeItemQuantity();
                   SharedCart.removeItemType();
                   SharedCart.removeItemPrice();
                       })};
                       

        /*   $scope.pushCart = function()
           {
                              
               var id = SharedCart.getItemId();
               var itemName = SharedCart.getItemName();
               var price = SharedCart.getItemPrice();
               var type = SharedCart.getItemType();     
               var quantity = SharedCart.getItemQuantity();    
               
               $scope.cart.id = id;
               $scope.cart.itemName = itemName;
               $scope.cart.price = price;
               $scope.cart.type = type;     
               $scope.cart.quantity = quantity;    
               return $scope.cart;
           }*/
       /*$scope.addCart= function (a){                 
           $http({
           method:'POST',
       url:'/api/cart/add',
       data: $scope.cart
           }).then(function(response)
                   {                      
                   })};*/

/*$scope.addOne= function(a)
                    {
                       $scope.cart.id=  SharedCart.getItemId();
                       $scope.cart.item = SharedCart.getItemName();
                       $scope.cart.quantity = SharedCart.getItemQuantity();
                       $scope.cart.price =  SharedCart.getItemPrice();
                       addCart($scope.cart);
                    }
*/
   $scope.updateCart=function (a) {$http({
                       method:'PUT',
                       url:'/api/cart/' + cart.id,
                       data: $scope.cart
                       
                           }).then(function(response)
                       {})};
                       

   $scope.getCart = function (a) {
       
       
       
                       $http({
                           method:'GET',
                               url:'/api/cart/'+ $scope.cart.id,
                           })
                               .then(function(response)
                               {
                                   $scope.cart= response.data;
                                   
                                   SharedCart.removeItemId();
                                   SharedCart.removeItemName();
                                   SharedCart.removeItemQuantity();
                                   SharedCart.removeItemType();
                                   SharedCart.removeItemPrice();
                                   
                                   
                                   SharedCart.changeItemId($scope.cart.id);
                                   SharedCart.changeItemName($scope.cart.item);                              
                                   SharedCart.changeItemQuantity($scope.cart.available);
                                   SharedCart.changeItemType($scope.cart.type);
                                   SharedCart.changeItemPrice($scope.cart.price);
                                                                 
                                         //$log.info(response);
                                   console.log($scope.cart);
                                       
                                       //$log.info(response);
                               })}; 


                               
                               
                               
                       
   $scope.deleteCart=function (a) {$http({
                       method:'DELETE',
                       url:'/api/cart/' + $scope.cart.id,
                       data: $scope.cart
                       
                           }).then(function(response)
                       {})};
 

    
                       /*   $scope.cartValue = 0;
    $scope.cartSize = 0;    
    $scope.howMuch = 0;
    $scope.itemSelected;
    
    $scope.carts;*/
    
  /*  $scope.cart = {
                    id:'',      
                    itemName: '',
                    quantity : '',
                    price : ''
                 };
        */
        
    /*$scpoe.addToCart = function()
    {       
            $scope.cart.id = $scope.cartSize++;
            
            $scope.cart.itemName = $scope.itemName;
            
            $scope.cart.quantity = $scope.howMuch;
            
            //depleteCart(howMuch); 
            
            $scope.cart.price = itemPrice * $scope.howMuch;
            
            return $scope.carts = $scope.cart;
            
            //$scope.cart.price =  $scope.cartsb..;
    }
    */
    
   /*$scope.showCart =  function()
    {
       $scope.cart.id = SharedCart.getItemId();
       $scope.cart.name = SharedCart.getItemName();
       $scope.cart.quantity = SharedCart.getItemQuantity();
       $scope.cart.price = SharedCart.getItemPrice();
       $scope.cart.type = SharedCart.getItemType();
             return $scope.carts;      
    }  
*/


});

