package uk.sky.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.sky.challenge.model.City;
import uk.sky.challenge.model.Product;
import uk.sky.challenge.repository.ProductRepository;

import java.util.List;


@Service
public class CatalogueService {

    @Autowired
    ProductRepository productRepo;


    public List<Product> findByCity(City city) {
        List<Product> noCities = productRepo.findByCityIsNull();
        if(city!=null) {
            noCities.addAll(productRepo.findByCity(city));
        }
        return noCities;
    }
}
