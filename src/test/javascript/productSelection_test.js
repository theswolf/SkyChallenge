'use strict';

describe('myApp.prodSel.productSelectionDirective directive', function() {

  beforeEach(module('myApp.prodSel.productSelectionDirective'));

  describe('ProductSelection directive', function(){

    it('should evaluate node 0 to be PROD-SEL', function() {
          module(function($provide) {
                             $provide.service('backend', function() {
                               this.getLocation = jasmine.createSpy('getLocation').andCallFake(function() {
                                 return('London')
                               });
                               this.getProduct = jasmine.createSpy('getProduct').andCallFake(function(city) {
                                 return [{"id":4,"name":"Sky NEWS","city":null,"category":"NEWS"},{"id":5,"name":"Sky Sports NEWS","city":null,"category":"NEWS"},{"id":1,"name":"Arsenal TV","city":{"name":"London"},"category":"SPORTS"},{"id":2,"name":"Chelsea TV","city":{"name":"London"},"category":"SPORTS"}];
                               });
                             });
                           });
          inject(function($compile,$rootScope) {
                $rootScope.city = 'London';
                var node = $compile('<prod-sel city="city"></prod-sel>')($rootScope);
                expect(node[0].nodeName).toEqual("PROD-SEL");
              });
        });


    it('should evaluate node 0 to be CATEGORY-SEL', function() {
              module(function($provide) {
                                 $provide.service('backend', function() {
                                   this.getLocation = jasmine.createSpy('getLocation').andCallFake(function() {
                                     return('London')
                                   });
                                   this.getProduct = jasmine.createSpy('getProduct').andCallFake(function(city) {
                                     return [{"id":4,"name":"Sky NEWS","city":null,"category":"NEWS"},{"id":5,"name":"Sky Sports NEWS","city":null,"category":"NEWS"},{"id":1,"name":"Arsenal TV","city":{"name":"London"},"category":"SPORTS"},{"id":2,"name":"Chelsea TV","city":{"name":"London"},"category":"SPORTS"}];
                                   });
                                 });
                               });
              inject(function($compile,$rootScope) {
                    $rootScope.key = 'Sport';
                    $rootScope.value={"id":4,"name":"Sky NEWS","city":null,"category":"NEWS"};
                    $rootScope.allproducts = []
                    var node = $compile('<category-sel category="key" products="value" allproducts="products" ></category-sel>')($rootScope);
                    expect(node[0].nodeName).toEqual("CATEGORY-SEL");
                  });
            });



  });
});


