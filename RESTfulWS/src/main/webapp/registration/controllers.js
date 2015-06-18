(function() {
  'use strict';

angular.module('myApp.registration')
.controller('registrationFormCtrl', ['$scope', 'Users', function($scope, Users) {
  $scope.duplicateUser = false;

  $scope.model = {userName:'', password:''};
  $scope.validateUser = function() {
    Users.get({
          userName: $scope.model.userName
        }, function(user) {
          if(user!==null) $scope.duplicateUser = true;
        });
  };

}]);
})();
