describe('myApp.backend.backendservice module', function() {

  beforeEach(module('myApp.backend.backendservice'));

  describe('BackendService backend', function(){

    it('should vallidate definition of backend service', inject(function(backend) {
      expect(backend.getLocation).toBeDefined();
      expect(backend.getLocation).toEqual(jasmine.any(Function));
      expect(backend.getProduct).toBeDefined();
      expect(backend.getProduct).toEqual(jasmine.any(Function));
      expect(backend.confirm).toBeDefined();
      expect(backend.confirm).toEqual(jasmine.any(Function));
    }));

  });
});
