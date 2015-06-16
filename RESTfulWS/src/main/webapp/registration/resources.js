(function() {
  'use strict';
  angular.module('myApp.registration')
    .factory('Users', ['$resource', function($resource) {
      return $resource('users/:userName', {}, {
        get: { method: 'GET'}
      });
    }]);
})();
