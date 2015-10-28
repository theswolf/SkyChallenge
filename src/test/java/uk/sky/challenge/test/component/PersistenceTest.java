package uk.sky.challenge.test.component;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.sky.challenge.SkyChallenge;
import uk.sky.challenge.model.City;
import uk.sky.challenge.repository.CitiesRepository;
import uk.sky.challenge.repository.ProductRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SkyChallenge.class)
public class PersistenceTest {

    @Autowired
    CitiesRepository citiesRepo;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldHaveStored2Cities() {
        assertEquals(2l,citiesRepo.count());
    }

    @Test
    public void shouldHaveStored4Products() {
        assertEquals(5l,productRepository.count());
    }

    @Test
    public void shouldFind2ResultForLondon() {
        assertEquals(2l,productRepository.findByCity(new City("London")).size());
    }

    @Test
    public void shouldFind1ResultForLiverpool() {
        assertEquals(1l,productRepository.findByCity(new City("Liverpool")).size());
    }

    @Test
    public void shouldFind2ResultWithNoCities() {
        assertEquals(2l,productRepository.findByCityIsNull().size());
    }
}


