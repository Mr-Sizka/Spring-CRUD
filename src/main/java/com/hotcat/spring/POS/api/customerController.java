package com.hotcat.spring.POS.api;

import com.hotcat.spring.POS.CustomerDto.CustomerDto;
import com.hotcat.spring.POS.entity.Customer;
import com.hotcat.spring.POS.paginated.paginatedCustomerResponseDto;
import com.hotcat.spring.POS.service.CustomerService;
import com.hotcat.spring.POS.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class customerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDto dto){

        return new ResponseEntity<>(new StandardResponse(
                201,
                customerService.saveCustomer(dto)+" saved!",
                customerService.saveCustomer(dto)
        ), HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDto dto){
        return new ResponseEntity<>(new StandardResponse(
                200,
                customerService.updateCustomer(dto)+" Updated!",
                customerService.updateCustomer(dto)
        ),HttpStatus.OK
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam String id){

        return new ResponseEntity<>(new StandardResponse(
                204,
                "Delete customer!",
                customerService.deleteCustomer(id)
        ),HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StandardResponse> getCustomer(@PathVariable String id){
        return new ResponseEntity<>(new StandardResponse(
                200,
                "Customer Data",
                customerService.getCustomer(id)
        ),HttpStatus.OK
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllCustomer(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String searchText){

        return new ResponseEntity<>(new StandardResponse(
                200,
                "Customer List",
                customerService.getAllCustomer(page,size,searchText)
        ),HttpStatus.OK
        );
    }
}
