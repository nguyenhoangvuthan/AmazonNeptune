package com.cdp.amazonNeptune.controller.customer;

import com.cdp.amazonNeptune.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

@RequestMapping("/api")
@RestController
public class CustomerController implements ICustomerController{


    private final CustomerRepository customerService;

    public CustomerController(CustomerRepository customerService) {
        this.customerService = customerService;
    }

    @Override
    @GetMapping("/managerCustomer/getAll/{page}")
    public ResponseEntity<JSONObject> findAll(@PathVariable(name="page") int PageNumber) {
        return new ResponseEntity<>(customerService.findAll(PageNumber), HttpStatus.OK);
    }

    @Override
    @GetMapping("/managerCustomer/filterByName/{page}")
    public ResponseEntity<JSONObject> findByName(@RequestParam(value = "name", required = false) String name, @PathVariable(name = "page") int PageNumber) {
        return new ResponseEntity<>(customerService.findByName(name,PageNumber), HttpStatus.OK);
    }

    @Override
    @GetMapping("/managerCustomer/filterByCountry/{page}")
    public ResponseEntity<JSONObject> findByCountry(@RequestParam(value = "country", required = false)String country,@PathVariable(name = "page") int PageNumber) {
        return new ResponseEntity<>(customerService.findByCountry(country,PageNumber), HttpStatus.OK);
    }

    @Override
    @GetMapping("/managerCustomer/filterByLocation/{page}")
    public ResponseEntity<JSONObject> findByLocation(@RequestParam(value = "location", required = false) String location,@PathVariable(name = "page") int PageNumber) {
        return new ResponseEntity<>(customerService.findByLocation(location,PageNumber), HttpStatus.OK);
    }

    @Override
    @GetMapping("/managerCustomer/filterByTelephone/{page}")
    public ResponseEntity<JSONObject> findByTelephone(@RequestParam(value = "telephone", required = false) String telephone,@PathVariable(name = "page") int PageNumber) {
        return new ResponseEntity<>(customerService.findByTelephone(telephone,PageNumber), HttpStatus.OK);
    }

}
