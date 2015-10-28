'use strict';

describe('myApp.changeCustomer module', function() {

  beforeEach(module('myApp.changeCustomer','ngCookies','myApp.backend.backendservice'));

  describe('ChangeCustomer controller', function(){

    it('should validate 4 available options', inject(function($controller,$rootScope) {
      //spec body
      var scope = $rootScope.$new();
      var ChangeCustomerCtrl = $controller('ChangeCustomerCtrl',{$scope:scope });
      expect(ChangeCustomerCtrl).toBeDefined();
      expect(scope.data.availableOptions.length).toBe(4);
    }));

  });
});