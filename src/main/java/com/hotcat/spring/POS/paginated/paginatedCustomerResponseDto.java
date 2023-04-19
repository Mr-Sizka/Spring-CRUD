package com.hotcat.spring.POS.paginated;

import com.hotcat.spring.POS.CustomerDto.CustomerDto;
import com.hotcat.spring.POS.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class paginatedCustomerResponseDto {
    private Page<Customer> list;
    private long dataCount;
}
