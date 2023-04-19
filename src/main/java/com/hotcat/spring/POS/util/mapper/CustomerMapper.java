package com.hotcat.spring.POS.util.mapper;

import com.hotcat.spring.POS.CustomerDto.CustomerDto;
import com.hotcat.spring.POS.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerDto.class, Customer.class})
public interface CustomerMapper {

    Customer toCustomer(CustomerDto dto);
    CustomerDto toCustomerDto(Customer customer);

    List<CustomerDto> toCustomerDtoList(Page<Customer> entities);

}
