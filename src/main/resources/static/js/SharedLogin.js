
myApp.service('SharedLogin', function() {
  
  var state = [];
  var rState = [];
  
  var changeState = function(newObj) {
      state.push(newObj);
  }

  var getState = function(){
      return state;
  }
  var removeState = function()
  {
      return state.pop();
  }
  

  var changeRState = function(newObj) {
      rState.push(newObj);
  }

  var getRState = function(){
      return rState;
  }
  var removeRState = function()
  {
      return rState.pop();
  }
  
  
  return {
    changeRState : changeRState,
    getRState: getRState,
    removeRState : removeRState,
    
    changeState : changeState,
    getState: getState,
    removeState : removeState
  };

});