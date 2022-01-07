package com.cdp.amazonNeptune.service.PaginationCustomer;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PagingObject implements IPagingObject{

    List<Map<String, Object>> customerscurrentnumber;

    List<Map<String, Object>> customerpreviousnumber;

    List<Map<String, Object>> customernextnumber;

    List<Map<String, Object>> customerfirstnumber;

    List<Map<String, Object>> customerlastnumber;
    
    long customerpagesize;

    @Override
    public List<Map<String, Object>> previousPageNumber(List<Map<String, Object>> customers, int PageNumber) {
        
        customerpreviousnumber = customers.subList((PageNumber-1)*3, (PageNumber*3-1)+ 3);
        return customerpreviousnumber;
    }

    @Override
    public List<Map<String, Object>> nextPageNumber(List<Map<String, Object>> customers, int PageNumber) {
        customernextnumber = customers.subList((PageNumber+1)*3, (PageNumber*3+1)+ 3);
        return customernextnumber;
    }

    @Override
    public List<Map<String, Object>> currentPageNumber(List<Map<String, Object>> customers, int PageNumber) {
        int temp = (int)PageSize(customers)*3 - customers.size();
        if(PageNumber == PageSize(customers))
             customerscurrentnumber = customers.subList(PageNumber*3, PageNumber*3 + 3-temp);
        else
            customerscurrentnumber = customers.subList(PageNumber*3, PageNumber*3 + 3);
        return customerscurrentnumber;
    }

    @Override
    public List<Map<String, Object>> firstPageNumber(List<Map<String, Object>> customers) {
        customerfirstnumber = customers.subList(0, 3);
        return  customerfirstnumber;
    }

    @Override
    public List<Map<String, Object>> lastPageNumber(List<Map<String, Object>> customers) {
        customerlastnumber = customers.subList(customers.size()-4, customers.size()-1);
        return customerlastnumber; 
    }

    @Override
    public long PageSize(List<Map<String, Object>> customers) {
        customerpagesize = customers.size()/3;
        return customerpagesize;
    }
   
}
