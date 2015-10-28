package uk.sky.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.sky.challenge.error.NotFoundError;
import uk.sky.challenge.model.City;
import uk.sky.challenge.model.Product;
import uk.sky.challenge.service.CatalogueService;
import uk.sky.challenge.service.CustomerLocationService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping("byCity/{cityId}")
    public List<Product> findByCity(@PathVariable("cityId") String city) throws Exception {

        return city != null ? catalogueService.findByCity(new City(city)) :
                catalogueService.findByCity(null);



    }

    @RequestMapping(value = "confirm",method = RequestMethod.POST)
    public Map<String,Object> confirm(@RequestBody LinkedList<String> products,HttpServletRequest request) throws Exception {

        Map<String,Object> retMap = new HashMap<>();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equalsIgnoreCase("customerID")) {
                Integer id = Integer.valueOf(cookie.getValue());
                retMap.put("CUSTOMERID",id);
            }
        }
        retMap.put("PRODUCTS",products);
        return retMap;
    }


}
