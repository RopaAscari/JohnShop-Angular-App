
myApp.controller('StudentController',  function($scope,$http,$window,$log,$localStorage,$sessionStorage) {
    $scope.product = 0;
    $scope.i =10;
    var sum = 0.0;
    var one= [];
    
 $scope.student={id:'',		
				name: '',
				studentId : ''};


 $scope.order={ 
         id:'',      
         itemName: '',
         amtDue : '',
         location : '',
         name : '',
         studentId : ''
     };



$scope.studentPick = 0;                            


	$window.onload = function () {		
  $http({
      method:'GET',
          url:'/api/order/all'
  		})
      .then(function(response)
      {
              $scope.orders= response.data;  
              console.log($scope.orders);
            
      })
      };
        
$scope.addStudent= function (){
	 
	$http({
  
        method:'POST',
        url:'/api/student/add',
		data: $scope.student
			}).then(function(response)
                    {
		
			
		
                    })};




$scope.updateStudent=function (a) {$http({
                    method:'PUT',
                    url:'/api/student/' +  $scope.selectedStudent,
                    data: $scope.student
                    
                        }).then(function(response)
                    {})};




$scope.deleteStudent=function (a) {$http({
                    method:'DELETE',
                    url:'/api/student/' +  $scope.selectedStudent,                   
                    
                        }).then(function(response)
                    {})};


$scope.update = true;    
$scope.selectedStudent = 0;                
                 


$scope.IsUpdate = function()
{
    if ($scope.selectedStudent != 0 )
        {
            return $scope.update = false;
        } 
}

                    


$scope.delete = true;              
                 

$scope.IsDelete = function()
{
    if ($scope.selectedStudent != 0 )
        {
            return $scope.delete = false;
        } 
}
/*   var movies = ["Reservoir Dogs", "Pulp Fiction", "Jackie Brown", 
"Kill Bill", "Death Proof", "Inglourious Basterds"];
$scope.movieList;    


$scope.saveTest = function() {
localStorage.setItem("movies", JSON.stringify(movies));                                
}



$scope.loadTest = function() {
if(localStorage.getItem('movies') != null){
$scope.movieList = JSON.parse(localStorage.getItem('movies'));          
}

}*/
   
$scope.getStudent = function (a) {        
                    $http({
                        method:'GET',
                        url:'/api/student/'+  $scope.student.id,
                     //   data: $scope.student
                        }).then(function(response)
                            {
                              $scope.student= response.data;                                                                        
                                    //$log.info(response);  
                               console.log($scope.student);
                            })};
                   
                      
    $scope.save = function() {
        
        //              STUDENT                                
        localStorage.setItem("studentName", JSON.stringify($scope.student.name));
        
        
        localStorage.setItem("studentId", JSON.stringify($scope.student.studentId));
        
        
        localStorage.setItem("studentLocation", JSON.stringify($scope.location));
    
       
    }
                            
/*
    $scope.load = function() {
        //              STUDENT  INFO                           
        
        if(localStorage.getItem('studentName') != null){
            $scope.name = JSON.parse(localStorage.getItem('studentName'));          
         }
             
        if(localStorage.getItem('studentId') != null){
            $scope.stu = JSON.parse(localStorage.getItem('studentId'));          
         }
               
        if(localStorage.getItem('studentLocation') != null){
            $scope.loco = JSON.parse(localStorage.getItem('studentLocation'));          
         }
        
        //             CART INFO                  
        if(localStorage.getItem('cartItem') != null){
            $scope.item = JSON.parse(localStorage.getItem('cartItem'));          
         }        
                              
        if(localStorage.getItem('cartPrice') != null){
            var one = JSON.parse(localStorage.getItem('cartPrice'));    
            var sum = 0;
            for (var i=0; i < one.length; i++)
                {
                    sum = sum +one[i]; 
                }
            $scope.price = sum;
         }
    }                           
    */


                            
    $scope.addOrder= function (){
        //        Student
   
	    
    	  if(localStorage.getItem('studentName') != null){
              $scope.name = JSON.parse(localStorage.getItem('studentName'));          
           }               
    	  $scope.order.name = $scope.name;
    	  
          if(localStorage.getItem('studentId') != null){
              $scope.stu = JSON.parse(localStorage.getItem('studentId'));          
           }
           $scope.order.studentId = $scope.stu;
          
          if(localStorage.getItem('studentLocation') != null){
              $scope.loco = JSON.parse(localStorage.getItem('studentLocation'));          
           }
          $scope.order.location =  $scope.loco;
        
        //             CART INFO                  
        if(localStorage.getItem('cartItem') != null){
            $scope.order.itemName = JSON.parse(localStorage.getItem('cartItem'));          
         }        
                              
        if(localStorage.getItem('cartPrice') != null){
             one = JSON.parse(localStorage.getItem('cartPrice'));    
   
            for (var i=0; i < one.length; i++)
                {           
                    sum = sum +  one[i] ;// * ($scope.cart.available); 
                }
            $scope.order.amtDue = sum;
        }                  
        $http({
            method:'POST',
            url:'/api/order/add',
            data: $scope.order
                }).then(function(response)
                        {
                    console.log($scope.order);
                        })};
                        
       
                        

$scope.clearCart = function () {      
	
 
    	
    	
                    $http({
                        method:'DELETE',
                    url:'/api/cart/clear'                
                    }).then(function(response)
                        {                        
                        })
    
                        
       
        };               

        

       

        
});           