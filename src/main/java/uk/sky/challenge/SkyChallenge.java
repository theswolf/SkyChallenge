package uk.sky.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import uk.sky.challenge.model.Category;
import uk.sky.challenge.model.City;
import uk.sky.challenge.model.Product;
import uk.sky.challenge.repository.CitiesRepository;
import uk.sky.challenge.repository.ProductRepository;

/**
 * Created by christian on 26/10/15.
 */
@SpringBootApplication

public class SkyChallenge {

    public static void main(String[] args) {
        SpringApplication.run(SkyChallenge.class);
    }



    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {

            @Autowired CitiesRepository citiesRepo;
            @Autowired ProductRepository productRepository;

            @Override
            public void run(String... strings) throws Exception {

                City london = new City("London");
                City liverpool = new City("Liverpool");

                citiesRepo.save(london);
                citiesRepo.save(liverpool);

                Product arsenalTV = new Product("Arsenal TV",london, Category.SPORTS);
                Product chelseaTV = new Product("Chelsea TV",london, Category.SPORTS);
                Product liverpoolTV = new Product("Liverpool TV",liverpool, Category.SPORTS);
                Product skyNews = new Product("Sky NEWS",null, Category.NEWS);
                Product skySportNews = new Product("Sky Sports NEWS",null, Category.NEWS);

                productRepository.save(arsenalTV);
                productRepository.save(chelseaTV);
                productRepository.save(liverpoolTV);
                productRepository.save(skyNews);
                productRepository.save(skySportNews);


            }
        };
    }
}
