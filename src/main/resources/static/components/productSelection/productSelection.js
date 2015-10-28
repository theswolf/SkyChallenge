angular.module('myApp.prodSel.productSelectionDirective', [])
.directive('prodSel', function() {
  return {
    restrict: 'E',
    //replace: true,
    transclude:true,
    scope: {
          city: '='
     },
    controller: ['$scope','backend', function($scope,backend) {

        $scope.backend = backend;
     }],
    link: function(scope, elm, attr) {
        scope.products = {};
        scope.notify = function(msg) {
            angular.extend(scope.basket, msg);
            console.log(scope.basket);
        }

        scope.basket = {};
        scope.propLength = function() {
                    var counter=1;
                    for(prop in scope.products) {
                        counter++;
                    }
                    return counter;
                }
        scope.backend.getProduct(scope.city)
                          .success(function(data) {
                            angular.forEach(data, function(value) {

                                      scope.products[value.category] = scope.products[value.category] || [];
                                      scope.products[value.category].push(value);
                                    });
                          })
                          .error(function(data, status) {
                            scope.errorText = data.message;
                          });
        /*scope.$watch('products',function(){
            scope.watchedlist = scope.products;
        },true);*/
    },
    templateUrl: '/components/productSelection/prodSelectionTemplate.html'
  };
})
.directive('categorySel', function() {
  return {
    restrict: 'E',
    //replace: true,
    transclude:true,
    scope: {
          category: '=',
          products: '=',
          size:'=',
          notify:'&'
     },
    link: function(scope, elm, attr) {

        scope.width = Math.floor(100/scope.size)+'%';
        scope.values = {};
        scope.$watch('values',function(value){
            scope.notify()(value);

        },true);


        scope.customStyle = {
            'width':scope.width,
            'border':'1px solid black' ,
            'height':'250px',
            'position':'relative',
            'float':'left'
        };
    },
    templateUrl: '/components/productSelection/catSelectionTemplate.html'
  };
})
.directive('cart', function() {
  return {
    restrict: 'E',
    //replace: true,
    transclude:true,
    scope: {
          size:'=',
          basket:'='
     },
    controller: ['$scope','backend','$rootScope','$location' ,function($scope,backend,$rootScope,$location) {
            $scope.backend = backend;
            $scope.rootScope = $rootScope;
            $scope.location = $location;
         }],
    link: function(scope, elm, attr) {

        scope.width = Math.floor(100/scope.size)+'%';
        /*scope.$watch('products',function(){
            scope.watchedlist = scope.products;
        },true);*/
        scope.confirm = function() {
            var data = [];
            for(prop in scope.basket) {
                  scope.basket[prop] && data.push(prop);
            }
            scope.backend.confirm(data)
            .success(function(data) {
                      scope.errorText = "";
                      scope.rootScope.confirmed = data;
                      scope.location.path('/confirmationPage')
                    })
            .error(function(data, status) {
                      $scope.errorText = data.message;
                    })
        };
        scope.customStyle = {
            'width':scope.width,
            'border':'1px solid black' ,
            'height':'250px',
            'position':'relative',
            'float':'left'
        };
    },
    templateUrl: '/components/productSelection/cartTemplate.html'
  };
});