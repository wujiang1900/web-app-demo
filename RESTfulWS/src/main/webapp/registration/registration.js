(function() {
  'use strict';

angular.module('myApp.registration', ['ngRoute','ngResource'])
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/register', {
    templateUrl: 'registration/registrationForm.html',
    controller: 'registrationFormCtrl'
  }).when('/confirm', {
    templateUrl: 'registration/registrationConfirmation.html',
    controller: 'registrationFormCtrl'
  }).otherwise({
        redirectTo: '/register'
      });
}]);
})();
