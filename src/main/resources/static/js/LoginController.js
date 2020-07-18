
myApp.controller('LoginController',  function($scope,$log,SharedLogin) {

    $scope.Pass = true;
    $scope.RPass = true;
    
  
    
    SharedLogin.changeState($scope.Pass);
    SharedLogin.changeRState($scope.RPass);
    
    // Login Usernames
   var managerUsername= "John";        
   var riderUsername= "Runner";

    // Login Passwords
 var managerPassword="myshop";
 var riderPassword="deliverMe";

$scope.login = function()
            {
             
    
   
    
                if ($scope.username  == riderUsername && $scope.password  == riderPassword)
                    {
                        SharedLogin.removeState();
                        $scope.Pass = false;                        
                        $scope.Pass= SharedLogin.changeState($scope.Pass);
                        
                  
                       return  $scope.Pass; 
                         
                    }
                else
                if($scope.username  == managerUsername && $scope.password  == managerPassword )
                {
                    SharedLogin.removeState();
                    $scope.Pass = false;                        
                    $scope.Pass= SharedLogin.changeState($scope.Pass);
                    
                    SharedLogin.removeRState();
                    $scope.RPass = false;                        
                    $scope.RPass= SharedLogin.changeState($scope.RPass);
                 //   return $scope.RPass;
                }
                $scope.RPass = true;                        
                $scope.RPass= SharedLogin.changeState($scope.RPass);
                return $scope.RPass;
            }
           
});

