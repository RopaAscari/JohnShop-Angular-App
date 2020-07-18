
myApp.service('SharedCart', function() {    
    
 var itemId = [];
 var itemName = [];
 var itemQuantity = [1];
 var itemStock = [];
 var itemPrice = [];
 var itemType= [];
 
 
 

 
 var changeItemId = function(newObj) {
     itemId.push(newObj);
 }

 var getItemId = function(){
     return itemId;
 }
 var removeItemId = function()
 {
     while(itemId.length)
     {
        itemId.pop();
     }
     
 }   
 
 var changeItemStock = function(newObj) {
     itemStock.push(newObj);
 }

 var getItemStock = function(){
     return itemStock;
 }
 var removeItemStock = function()
 {
     while(itemStock.length)
     {
        itemStock.pop();
     }
     
 }   



 var changeItemType = function(newObj) {
     itemType.push(newObj);
 }

 var getItemType = function(){
     return itemType;
 }
 
 
 var removeItemType = function()
 {
   
     while(itemType.length)
     {
         itemType.pop();
     }     
 }   
 
 
 
 var changeItemPrice = function(newObj) {
     itemPrice.push(newObj);
 }
 var getItemPrice = function(){
     return itemPrice;
 }
 var removeItemPrice = function()
 {
     while(itemPrice.length)
         {
            itemPrice.pop();
         }
     
 }
 
 
 
 var changeItemQuantity = function(newObj) {
     itemQuantity.push(newObj);
 }

 var getItemQuantity = function(){
     return itemQuantity;
 }
 var removeItemQuantity = function()
 {
     while (itemQuantity.length)
     {
          itemQuantity.pop();    
     }
     
 }
 
 
 
 var changeItemName = function(newObj) {
     itemName.push(newObj);
 }

 var getItemName = function(){
     return itemName;
 }
 var removeItemName = function()
 {
     while(itemName.length)
         {
             itemName.pop();
         }     
 }

 
    return {
        changeItemPrice : changeItemPrice,
        getItemPrice: getItemPrice,
        removeItemPrice : removeItemPrice,
        
        changeItemName : changeItemName,
        getItemName: getItemName,
        removeItemName : removeItemName,
        
        changeItemId : changeItemId,
        getItemId: getItemId,
        removeItemId : removeItemId,
        
        changeItemType : changeItemType,
        getItemType: getItemType,
        removeItemType : removeItemType,
        
        changeItemQuantity : changeItemQuantity,
        getItemQuantity: getItemQuantity,
        removeItemQuantity : removeItemQuantity,      
        
        changeItemStock : changeItemStock,
        getItemStock: getItemStock,
        removeItemStock : removeItemStock     
    };

  });