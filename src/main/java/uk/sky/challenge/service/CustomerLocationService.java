package uk.sky.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import uk.sky.challenge.error.NotFoundError;
import uk.sky.challenge.model.City;
import uk.sky.challenge.repository.CitiesRepository;


@Service
public class CustomerLocationService {

    @Autowired
    CitiesRepository citiesRepo;

    public City stubService(int customerID) throws Exception {

        switch(customerID) {
            case 0:
                return citiesRepo.findOne("London");
            case 1:
                return citiesRepo.findOne("Liverpool");
            case 2:
                return null;
            default:
                throw new NotFoundError("There was a problem retrieving the customer information");
        }

    }
}
