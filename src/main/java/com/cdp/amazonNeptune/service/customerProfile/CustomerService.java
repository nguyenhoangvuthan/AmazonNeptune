package com.cdp.amazonNeptune.service.customerProfile;

import com.cdp.amazonNeptune.repository.CustomerRepository;
import com.cdp.amazonNeptune.service.PaginationCustomer.IPagingObject;
import com.cdp.amazonNeptune.service.PaginationCustomer.PagingObject;

import net.minidev.json.JSONObject;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.unfold;
import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.valueMap;

@Service
public class CustomerService implements CustomerRepository {


    @Autowired
    Cluster cluster;

    @Autowired
    GraphTraversalSource g;
    
    List<List<Map<String, Object>>> outputFromLinks;

    @Autowired
    IPagingObject pagingObject;

    @Override
    @Transactional(readOnly = true)
    public JSONObject findAll(int PageNumber) {

        try{
        outputFromLinks = new ArrayList<>();

        // NeptuneConnection neptuneConnection = new NeptuneConnection();
        // Cluster builder = neptuneConnection.cluster();
        // Client openCluster = builder.connect();
        // GraphTraversalSource g = traversal().withRemote(DriverRemoteConnection.using(openCluster));
        
     
        
        // List <Map<String,Object>> profiles = g.V().hasLabel("customer_cdp").as("customer_cdp").
        //         out("customer_cdp_to_cus_lsretail", "customer_cdp_to_cus_magento").as("customer_source").
        //         out("customer_lsretail_to_address_lsretail", "customer_magento_to_address_magento").as("address").
        //         select("customer_cdp", "customer_source", "address").
        //         by(valueMap("gender", "telephone", "Account_No_", "date_of_birth").by(unfold())).
        //         by(valueMap("Name").by(unfold())).
        //         by(valueMap("City", "street", "Country").by(unfold())).
        //         toList();

        List <Map<String,Object>> profiles = g.V().hasLabel("customer_cdp").as("customer_cdp").
                out("customer_cdp_to_cus_lsretail", "customer_cdp_to_cus_magento").as("customer_source").
                out("customer_lsretail_to_address_lsretail", "customer_magento_to_address_magento").as("address").
                select("customer_cdp", "customer_source", "address").
                by(valueMap("gender", "telephone", "Account_No_", "date_of_birth").by(unfold())).
                by(valueMap("Name").by(unfold())).
                by(valueMap("City", "street", "Country").by(unfold())).
                toList();
        
                
        
        if (profiles != null) {
            outputFromLinks.add(pagingObject.currentPageNumber(profiles, PageNumber));
        }

        JSONObject data = new JSONObject();
        data.appendField("limit", pagingObject.PageSize(profiles));
        data.put("customerprofile", outputFromLinks);
        
        return data;

        // FileWriter fw = new FileWriter("C:\\Users\\intern.nhvthan\\Desktop\\test12getAl.json");
        // fw.write(String.valueOf(data));
        // fw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
        
    }

    @Override
    @Transactional(readOnly = true)
    public JSONObject findByName(String name, int PageNumber) {
        
        outputFromLinks = new ArrayList<>();
        
        List<Map<String, Object>> detailbyname = g.V().hasLabel("customer_cdp").
                                    out("customer_cdp_to_cus_lsretail","customer_cdp_to_cus_magento").
                                    has("Name", name).
                                    as("customer_sources").
                                    out("customer_lsretail_to_address_lsretail","customer_magento_to_address_magento").
                                    as("customer_address").
                                    select("customer_sources","customer_address").
                                    by(valueMap().by(unfold())).
                                    by(valueMap().by(unfold())).
                                    toList()
                                    ;

                                    pagingObject = new PagingObject();
                    
                            
        if (detailbyname != null) {
            outputFromLinks.add( pagingObject.currentPageNumber(detailbyname, PageNumber));
        }
        
        
        JSONObject data = new JSONObject();
        data.appendField("limit", pagingObject.PageSize(detailbyname));
        data.put("Customer", outputFromLinks);
        return data;
    }

    @Override
    @Transactional(readOnly = true)
    public JSONObject findByCountry(String country, int PageNumber) {
        
        outputFromLinks = new ArrayList<>();

        List<Map<String, Object>> detailbycountry = g.V().hasLabel("customer_cdp").
                    out("customer_cdp_to_cus_lsretail", "customer_cdp_to_cus_magento").
                    has("Country", country).
                    as("customer_sources").
                    out("customer_lsretail_to_address_lsretail", "customer_magento_to_address_magento").
                    as("customer_address").
                    select("customer_sources", "customer_address").
                    by(valueMap().by(unfold())).
                    by(valueMap().by(unfold())).
                    toList();


        if (detailbycountry != null) {
            outputFromLinks.add(pagingObject.currentPageNumber(detailbycountry, PageNumber));
        }

        JSONObject data = new JSONObject();
        data.appendField("limit", pagingObject.PageSize(detailbycountry));
        data.put("customerprofile", outputFromLinks);
        return data;
    }

    @Override
    @Transactional(readOnly = true)
    public JSONObject findByLocation(String location, int PageNumber) {

        outputFromLinks = new ArrayList<>();

        List<Map<String, Object>> detailbylocation = g.V().hasLabel("customer_cdp").
                    out("customer_cdp_to_cus_lsretail","customer_cdp_to_cus_magento").
                    has("City", location).
                    as("customer_sources").
                    out("customer_lsretail_to_address_lsretail","customer_magento_to_address_magento").
                    as("customer_address").
                    select("customer_sources","customer_address").
                    by(valueMap().by(unfold())).
                    by(valueMap().by(unfold())).toList();


        if (detailbylocation != null) {
            outputFromLinks.add(pagingObject.currentPageNumber(detailbylocation, PageNumber));
        }

        JSONObject data = new JSONObject();
        data.appendField("limit", pagingObject.PageSize(detailbylocation));
        data.put("customerprofile", outputFromLinks);
        return data;
    }

    @Override
    @Transactional(readOnly = true)
    public JSONObject findByTelephone(String telephone, int PageNumber) {

        outputFromLinks = new ArrayList<>();

        List<Map<String, Object>> detailbytelephone = g.V().hasLabel("customer_cdp").
                    out("customer_cdp_to_cus_lsretail","customer_cdp_to_cus_magento").
                    has("telephone", telephone).
                    as("customer_sources").
                    out("customer_lsretail_to_address_lsretail","customer_magento_to_address_magento").
                    as("customer_address").
                    select("customer_sources","customer_address").
                    by(valueMap().by(unfold())).
                    by(valueMap().by(unfold())).toList();
        

        if (detailbytelephone != null) {
            outputFromLinks.add(pagingObject.currentPageNumber(detailbytelephone, PageNumber));
        }

        JSONObject data = new JSONObject();
        data.appendField("limit", pagingObject.PageSize(detailbytelephone));
        data.put("customerprofile", outputFromLinks);
        return data;
    }

   
}
