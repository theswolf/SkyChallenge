package uk.sky.challenge.test.component;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.sky.challenge.SkyChallenge;
import uk.sky.challenge.model.City;
import uk.sky.challenge.service.CatalogueService;
import uk.sky.challenge.service.CustomerLocationService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SkyChallenge.class)
public class ServiceTest {
    @Autowired
    private CatalogueService catalogueService;

    @Autowired
    private CustomerLocationService customerLocationService;

    @Test
    public void shouldFind3ResultForLiverpool(){
        assertEquals(catalogueService.findByCity(new City("Liverpool")).size(),3l);
    }

    @Test
    public void shouldFind4ResultForLondon(){
        assertEquals(catalogueService.findByCity(new City("London")).size(),4l);
    }

    @Test
    public void shouldFind2ResultForNoCity(){
        assertEquals(catalogueService.findByCity(null).size(),2l);
    }

    @Test
    public void shouldReturnLondonByCustomer() throws Exception {
        assertEquals(new City("London"),customerLocationService.stubService(0));
    }

    @Test
    public void shouldReturnLiverpoolByCustomer() throws Exception {
        assertEquals(new City("Liverpool"),customerLocationService.stubService(1));
    }

    @Test
    public void shouldReturnNullByCustomer() throws Exception {
        assertEquals(null,customerLocationService.stubService(2));
    }

    @Test(expected = Exception.class)
    public void shouldThrowException() throws Exception {
        customerLocationService.stubService(3);
    }

}


