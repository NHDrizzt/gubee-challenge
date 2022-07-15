package org.rokol.domain;

    import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
    import org.rokol.domain.model.FilterProduct;
    import org.rokol.domain.model.Market;
    import org.rokol.domain.model.Product;
    import org.rokol.domain.model.Stack;
import org.rokol.domain.ports.api.ProductService;
import org.rokol.domain.ports.spi.ProductRepository;
    import org.rokol.domain.usecase.ProductServiceImpl;
    import org.rokol.quarkus.adapter.repository.ProductRepositoryInMemoryImpl;
import org.rokol.quarkus.adapter.repository.ProductRepositoryJdbcImpl;
import org.rokol.quarkus.adapter.repository.ProductRepositoryProxyImpl;
    import org.rokol.quarkus.adapter.repository.model.AbstractDaoFactory;

    import javax.inject.Inject;

import java.util.ArrayList;
    import java.util.LinkedHashSet;
    import java.util.List;
    import java.util.Set;

    import static org.junit.jupiter.api.Assertions.*;
    import static org.mockito.Mockito.mock;

class ProductServiceImplTest {

   private ProductRepository productRepository;


    @BeforeEach
    void init() {
        productRepository = Mockito.mock(ProductRepositoryInMemoryImpl.class);
    }

    @Test
    void should_return_list_prod() {
        List<Market> marketList = new ArrayList<>();
        List<Stack> stackList = new ArrayList<>();
        Set<Product> setProd = new LinkedHashSet<>();

        marketList.add(new Market(1, "Ecommerce"));
        stackList.add(new Stack(1, "Java 10"));
        setProd.add(new Product(1, "Test", "Gubee Test"));

        Mockito.when(productRepository.listProductByMarketAndStack(marketList, stackList)).thenReturn(setProd);

        Set<Product> myList = productRepository.listProductByMarketAndStack(marketList, stackList);

        assertNotNull(myList);
        assertEquals(1L, myList.size());
        assertFalse(myList.isEmpty());
    }
}
