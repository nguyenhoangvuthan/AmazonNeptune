package com.cdp.amazonNeptune.service.PaginationCustomer;

import java.util.List;
import java.util.Map;

public interface IPagingObject {
    
    public List<Map<String, Object>> previousPageNumber(List<Map<String, Object>> customers, int PageNumber);

    public List<Map<String, Object>> nextPageNumber(List<Map<String, Object>> customers, int PageNumber);

    public List<Map<String, Object>> currentPageNumber(List<Map<String, Object>> customers, int PageNumber);

    public List<Map<String, Object>> firstPageNumber(List<Map<String, Object>> customers);

    public List<Map<String, Object>> lastPageNumber(List<Map<String, Object>> customers);

    public long PageSize(List<Map<String, Object>> customers);

}

