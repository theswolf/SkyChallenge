angular.module('myApp.backend.backendservice', [])
.service("backend", ['$http', '$q', function(http, q) {
  return {
    getLocation: function() {
      return http.get("/customer/byId");
    },
    getProduct: function(city) {
      city = city || "_";
      return http.get("/product/byCity/"+city);
    },
    confirm: function(data) {
      /*return http({
        url: "/product/confirm",
        method: "POST",
        data: angular.toJson(data),
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }
      });*/
      return http.post("/product/confirm",angular.toJson(data));
    }
  }
}]);