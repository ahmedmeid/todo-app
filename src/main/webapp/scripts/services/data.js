'use strict';

angular.module('todoListApp')
.service('dataService', function($http) {
  this.getTodos = function(cb) {
    $http.get('/todo').then(cb);
  };
  
  this.deleteTodo = function(todo) {
	var req = {
			    method : 'DELETE',
			    url    : '/todo/'+todo.id,
	          };
	$http(req).then(function(){
    console.log("I deleted the " + todo.name + " todo!");
	});
  };
  
  this.saveTodos = function(todos) {
  var req = {
				method : 'POST',
				url    : '/todo',
				data   : todos
		    };
	$http(req).then(function(response){
    console.log("I saved " + todos.length + " todos!");
    for(var i=0;i<todos.length;i++)
    	{
    	    todos[i].edited = false;
    	    todos[i].id = response.data[i];
    	}
	});
  };
  
});
