'use strict';

angular.module('myApp.changeCustomer', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/changeCustomer', {
    templateUrl: 'changeCustomer/changeCustomer.html',
    controller: 'ChangeCustomerCtrl'
  });
}])

.controller('ChangeCustomerCtrl', ["$scope","$rootScope","$location","$cookies","backend",function($scope,$rootScope,$location,$cookies,backend) {
  $scope.data = {
      customerSelection: null,
      availableOptions: [
        {id: '0', name: 'CustomerID 0 (London)'},
        {id: '1', name: 'CustomerID 1 (Liverpool)'},
        {id: '2', name: 'CustomerID 2 (Others City)'},
        {id: '3', name: 'Customer ID 3 (Error)'}
      ],
     };

   $scope.goToProductPage = function() {
        $cookies.put('CustomerID', $scope.data.customerSelection);
        backend.getLocation()
        .success(function(data) {
          $scope.errorText = "";
          $rootScope.city = ((!!data && !!data.name ) ? data.name : "");
          $location.path('/productSelection')
        })
        .error(function(data, status) {
          $scope.errorText = data.message;
        })
   };
}]);