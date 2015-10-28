package uk.sky.challenge.test.component;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.sky.challenge.SkyChallenge;
import uk.sky.challenge.controller.CustomerController;
import uk.sky.challenge.controller.ProductController;
import uk.sky.challenge.model.City;
import uk.sky.challenge.service.CatalogueService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SkyChallenge.class)
public class ControllerTest {

    @Autowired
    private CustomerController customerController;

    @Autowired
    private ProductController productController;

    @Autowired
    private CatalogueService catalogueService;

    private HttpServletRequest mockRequest(Integer customerId) {
        HttpServletRequest req = mock(HttpServletRequest.class);
        Cookie cookie = new Cookie("customerID",customerId != null ? customerId.toString() : null);
        when(req.getCookies()).thenReturn(new Cookie[]{cookie});
        return req;
    }


    @Test(expected = Exception.class)
    public void exepctExceptionForCustomer() throws Exception {
        customerController.getLocation(mockRequest(4));
    }



    @Test
    public void expectNotError() throws Exception {
        assertEquals(new City("London"), customerController.getLocation(mockRequest(0)));
        assertEquals(new City("Liverpool"),customerController.getLocation(mockRequest(1)));
        assertEquals(null,customerController.getLocation(mockRequest(2)));

    }

    @Test
    public void testProductController() throws Exception {
        assertEquals(catalogueService.findByCity(new City("London")).size(),
                productController.findByCity("London").size()
                );

        assertEquals(catalogueService.findByCity(new City("Liverpool")).size(),
                productController.findByCity("Liverpool").size()
        );

        assertEquals(catalogueService.findByCity(null).size(),
                productController.findByCity(null).size()
        );
    }


}
