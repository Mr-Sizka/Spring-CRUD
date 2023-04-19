package com.hotcat.spring.POS.service;

import com.hotcat.spring.POS.CustomerDto.CustomerDto;
import com.hotcat.spring.POS.entity.Customer;
import com.hotcat.spring.POS.paginated.paginatedCustomerResponseDto;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public interface CustomerService {
    String saveCustomer(CustomerDto dto);
    String updateCustomer(CustomerDto dto);
    String deleteCustomer(String id);
    CustomerDto getCustomer(String id);
    paginatedCustomerResponseDto getAllCustomer(
            int page ,
            int size,
            String searchText);

}
