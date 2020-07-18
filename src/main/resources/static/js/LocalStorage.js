myApp.service('LocalStorage',function($scope,$localStorage,$sessionStorage){
          
    
    $scope.save = function() {
        //              STUDENT
        
        localStorage.setItem("studentName", JSON.stringify($scope.student.name));
        
        
        localStorage.setItem("studentId", JSON.stringify($scope.student.studentId));
        
        
        localStorage.setItem("studentLocation", JSON.stringify($scope.location));
        
        //             CART
        
        localStorage.setItem("cartItem", JSON.stringify($scope.cart.item));
        
        
        
        localStorage.setItem("cartPrice", JSON.stringify($scope.cart.price));
    }

  

    $scope.load = function() {
        //              STUDENT  INFO                
        if(localStorage.getItem('studentName') != null){
           $scope.data = JSON.parse(localStorage.getItem('studentName'));          
        }
             
        if(localStorage.getItem('studentId') != null){
            $scope.data = JSON.parse(localStorage.getItem('studentId'));          
         }
               
        if(localStorage.getItem('studentLocation') != null){
            $scope.data = JSON.parse(localStorage.getItem('studentLocation'));          
         }
        
        
        //             CART INFO                  
        if(localStorage.getItem('cartItem') != null){
            $scope.data = JSON.parse(localStorage.getItem('cartItem'));          
         }        
                              
        if(localStorage.getItem('cartPrice') != null){
            $scope.data = JSON.parse(localStorage.getItem('cartPrice'));          
         }
    }                    
                
              
});