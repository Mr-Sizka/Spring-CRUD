package com.hotcat.spring.POS.service.impl;

import com.hotcat.spring.POS.CustomerDto.CustomerDto;
import com.hotcat.spring.POS.entity.Customer;
import com.hotcat.spring.POS.paginated.paginatedCustomerResponseDto;
import com.hotcat.spring.POS.repo.customerRepo;
import com.hotcat.spring.POS.service.CustomerService;
import com.hotcat.spring.POS.util.mapper.CustomerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class customerServiceImpl implements CustomerService {

    private final customerRepo repo;
    private final CustomerMapper customerMapper;

    public customerServiceImpl(customerRepo repo, CustomerMapper customerMapper) {
        this.repo = repo;
        this.customerMapper = customerMapper;
    }

    @Override
    public String saveCustomer(CustomerDto dto) {
         return repo.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary())).getName();

    }

    @Override
    public String updateCustomer(CustomerDto dto) {
        Optional<Customer> tempCustomer = repo.findById(dto.getId());
        if(tempCustomer.isPresent()){
            tempCustomer.get().setName(dto.getName());
            tempCustomer.get().setAddress(dto.getAddress());
            tempCustomer.get().setSalary(dto.getSalary());
            return repo.save(tempCustomer.get()).getName();
        }
        return "Customer not Found! ";
    }

    @Override
    public String deleteCustomer(String id) {
        Optional<Customer> tempCustomer = repo.findById(id);
        if (tempCustomer.isPresent()){
            repo.deleteById(id);
            return id;
        }
        return "Customer not found! ";
    }

    @Override
    public CustomerDto getCustomer(String id) {
        Optional<Customer> tempCustomer = repo.findById(id);
        if (tempCustomer.isPresent()){
            return customerMapper.toCustomerDto(tempCustomer.get());
        }
        return null;
    }

    @Override
    public paginatedCustomerResponseDto getAllCustomer(int page, int size,String searchText){
        Page<Customer> list = repo.getAll(searchText, PageRequest.of(page, size).withSort(Sort.by("id")));
        long allCount = repo.getAllCount(searchText);
        return new paginatedCustomerResponseDto(list,allCount);

    }
}
