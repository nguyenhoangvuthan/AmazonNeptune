package com.cdp.amazonNeptune.repository;
import net.minidev.json.JSONObject;

public interface CustomerRepository {
    // JSONObject findAll(IPagingObject page);
    // JSONObject findByName(String name, IPagingObject page);
    // JSONObject findByCountry(String country, IPagingObject page);
    // JSONObject findByLocation(String location, IPagingObject page);
    // JSONObject findByTelephone(String telephone, IPagingObject page);

    JSONObject findAll(int PageNumber);
    JSONObject findByName(String name, int PageNumber);
    JSONObject findByCountry(String country, int PageNumber);
    JSONObject findByLocation(String location, int PageNumber);
    JSONObject findByTelephone(String telephone, int PageNumber);
}
