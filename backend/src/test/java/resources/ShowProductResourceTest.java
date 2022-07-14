package resources;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rokol.domain.ProductServiceImpl;
import org.rokol.domain.dto.FilterProduct;
import org.rokol.domain.model.Market;
import org.rokol.domain.model.Product;
import org.rokol.domain.model.Stack;
import org.rokol.domain.ports.api.ProductService;
import org.rokol.domain.ports.spi.ProductRepository;
import org.rokol.quarkus.adapter.repository.ProductRepositoryInMemoryFactory;
import org.rokol.quarkus.adapter.repository.ProductRepositoryJdbcFactory;
import org.rokol.quarkus.adapter.repository.model.AbstractDaoFactory;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ShowProductResourceTest {
    private ProductService productService;
    private FilterProduct filterProduct;

    @BeforeEach
    void init(){
        AbstractDaoFactory abstractDaoFactoryMemory = new ProductRepositoryInMemoryFactory();
        productService = new ProductServiceImpl(abstractDaoFactoryMemory);
        filterProduct = new FilterProduct();
    }

    @Test
    void getListMarketAndStackTest() {
        Set<Product> myList = productService.getMarketAndStack(filterProduct.getMarket(), filterProduct.getStack());

        assertNotNull(myList);
        assertEquals(3, myList.size());
        assertFalse(myList.isEmpty());
    }
}
