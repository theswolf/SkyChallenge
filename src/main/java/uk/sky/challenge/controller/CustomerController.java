package uk.sky.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.sky.challenge.error.NotFoundError;
import uk.sky.challenge.model.City;
import uk.sky.challenge.service.CustomerLocationService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerLocationService customerLocationService;

    @RequestMapping("byId")
    public City getLocation(HttpServletRequest request) throws Exception {
        try {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equalsIgnoreCase("customerID")) {
                    Integer id = Integer.valueOf(cookie.getValue());
                    return customerLocationService.stubService(id);
                }
            }
            return null;
        } catch (Exception e) {
            throw new NotFoundError(e.getMessage());
        }
    }


}
