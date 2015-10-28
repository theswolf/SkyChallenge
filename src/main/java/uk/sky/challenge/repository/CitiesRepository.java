package uk.sky.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.sky.challenge.model.City;


@Repository
public interface CitiesRepository extends CrudRepository<City,String> {
}
