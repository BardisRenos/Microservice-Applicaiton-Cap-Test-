package customerTest.service;

import com.example.dao.CustomerRepository;
import com.example.dto.CustomerDTO;
import com.example.entity.Customer;
import com.example.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class customerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        this.customerRepository = mock(CustomerRepository.class);
        this.customerService = new CustomerServiceImpl(this.customerRepository);
    }

    @Test
    void getAllCustomers_whenAllCustomers_thenReturnAllCustomers() {

        List<Customer> customers = new ArrayList<>(Arrays.asList(
                new Customer(1, "Renos", "Bardis", 100),
                new Customer(2, "John", "Doe", 50),
                new Customer(3, "Nick", "Smith", 45)));

        when(customerRepository.findAll()).thenReturn(customers);
        List<CustomerDTO> customerList = customerService.getAllCustomers();

        assertAll("Check all entities",
                ()->assertEquals(3, customerList.size()),
                ()->assertEquals(1, customerList.get(0).getCustomerId()));
    }

    @Test
    void getCustomerById_whenCustomerExists_thenReturnCustomer() {
        Customer customer = new Customer(1, "Renos", "Bardis", 100);

        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        Customer res = customerService.getCustomerById(1);

        assertAll("Check all entities",
                ()->assertEquals(1, res.getCustomerID()),
                ()->assertEquals("Renos", res.getName()));
    }


}
