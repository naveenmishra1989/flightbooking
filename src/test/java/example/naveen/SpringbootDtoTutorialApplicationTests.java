package example.naveen;

import com.fasterxml.jackson.core.JsonProcessingException;
import example.naveen.controller.CustomerController;
import example.naveen.dto.CustomerDto;
import example.naveen.entity.Address;
import example.naveen.entity.Customer;
import example.naveen.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest(classes = SpringbootDtoTutorialApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureDataJpa
@TestPropertySource(locations = "classpath:application-test.properties")
class SpringbootDtoTutorialApplicationTests {

	@LocalServerPort
	private int port;
	@Autowired
	private CustomerController customerController;
	@Autowired
	private CustomerRepository customerRepository;


	@BeforeEach
	public void setup() {
		Address address = Address.builder()
				.city("Pune")
				.zip("12334")
				.street("Pune")
				.state("Maharashtra")
				.build();
		Customer customer = Customer.builder()
				.firstName("naveen").LastName("mishra")
				.address(address)
				.build();
		Customer saveCustomer = customerRepository.save(customer);
		System.out.println(saveCustomer);
	}

	@Test
	@Transactional
	public void testAllEmployees() throws JsonProcessingException {
		ResponseEntity<CustomerDto> customerById = customerController.getCustomerById(1L);
		System.out.println(customerById);
	}

}
