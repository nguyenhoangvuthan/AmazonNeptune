package com.cdp.amazonNeptune.controller.customer;

import com.cdp.amazonNeptune.common.ApiUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.minidev.json.JSONObject;

@RequestMapping(value = ApiUtils.API, produces = MediaType.APPLICATION_JSON_VALUE)
public interface ICustomerController{

    // --------------------------------
    // Get all schemas
    // --------------------------------
    @GetMapping(ApiUtils.CUSTOMER_PROFILE)
    // ResponseEntity<JSONObject> findAll(IPagingObject page);
    // ResponseEntity<JSONObject> findByName(String name, IPagingObject page);
    // ResponseEntity<JSONObject> findByCountry(String country, IPagingObject page);
    // ResponseEntity<JSONObject> findByLocation(String location, IPagingObject page);
    // ResponseEntity<JSONObject> findByTelephone(String telephone, IPagingObject page);
    //ResponseEntity<JSONObject> findByNamePaging(String name);

    ResponseEntity<JSONObject> findAll(int pagenumber);
    ResponseEntity<JSONObject> findByName(String name, int pagenumber);
    ResponseEntity<JSONObject> findByCountry(String country, int pagenumber);
    ResponseEntity<JSONObject> findByLocation(String location,int pagenumber);
    ResponseEntity<JSONObject> findByTelephone(String telephone, int pagenumber);

}
