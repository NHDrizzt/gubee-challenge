package resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rokol.domain.usecase.ProductServiceImpl;
import org.rokol.domain.model.FilterProduct;
import org.rokol.domain.model.Product;
import org.rokol.domain.ports.api.ProductService;
import org.rokol.quarkus.adapter.repository.ProductRepositoryInMemoryFactory;
import org.rokol.quarkus.adapter.repository.model.AbstractDaoFactory;

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
    void should_list_products() {
        Set<Product> myList = productService.getMarketAndStack(filterProduct.getMarket(), filterProduct.getStack());

        assertNotNull(myList);
        assertEquals(3, myList.size());
        assertFalse(myList.isEmpty());
    }
}
