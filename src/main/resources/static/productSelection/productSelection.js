'use strict';

angular.module('myApp.productSelection', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/productSelection', {
    templateUrl: 'productSelection/productSelection.html',
    controller: 'ProductSelectionCtrl'
  });
}])

.controller('ProductSelectionCtrl', ["$scope","$rootScope","$location","$cookies","backend",function($scope,$rootScope,$location,$cookies,backend) {


}]);