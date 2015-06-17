(function() {
  'use strict';
  angular.module('myApp.registration')
    // .factory('User', ['$resource', function($resource) {
    //   return $resource('/api/user/:userName', {}, {
    //     get: { method: 'GET'}
    //   });
    // }])
    .factory('Users', ['$resource', function($resource) {
      return $resource('api/users/:userName', {}, {
        get: { method: 'GET'}
      });
    }]);
})();
