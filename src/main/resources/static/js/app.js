/* 
 */

var empowerPeersApp = angular.module('empowerPeers', []);

empowerPeersApp.controller('user', function($scope, $http) {
  $http.get('/api/user/').success(function(data) {
    $scope.user = data;
  });
});

empowerPeersApp.controller('course', function($scope, $http) {
  $http.get('/api/courses/').success(function(data) {
    $scope.courses = data;
  });
});
