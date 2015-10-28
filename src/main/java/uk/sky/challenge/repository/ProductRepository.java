package uk.sky.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.sky.challenge.model.City;
import uk.sky.challenge.model.Product;

import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    public List<Product> findByCity(City city);
    public List<Product> findByCityIsNull();
}
