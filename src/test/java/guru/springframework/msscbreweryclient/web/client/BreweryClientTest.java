package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder()
                .beerName("Neues Bier")
                .build();
        System.out.println(beerDto);

        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Neues Bier").build();

        client.updateBeer(UUID.randomUUID(),  beerDto);
    }

    @Test
    void deleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    public void saveNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder()
                .name("Herbert")
                .id(UUID.randomUUID())
                .build();

        System.out.println(customerDto);

        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    public void updateCustomer(){
        CustomerDto customerDto = CustomerDto.builder()
                .name("Herbert")
                .build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    public void deleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}