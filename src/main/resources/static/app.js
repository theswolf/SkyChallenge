'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngCookies',
  'myApp.changeCustomer',
  'myApp.productSelection',
  'myApp.confirmationPage',
  'myApp.prodSel.productSelectionDirective',
  'myApp.backend.backendservice'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/changeCustomer'});
}]);
