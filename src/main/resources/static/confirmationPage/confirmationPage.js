'use strict';

angular.module('myApp.confirmationPage', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/confirmationPage', {
    templateUrl: 'confirmationPage/confirmationPage.html',
    controller: 'ConfirmationPageCtrl'
  });
}])

.controller('ConfirmationPageCtrl', ["$scope","$rootScope","$location","$cookies","backend",function($scope,$rootScope,$location,$cookies,backend) {

}]);