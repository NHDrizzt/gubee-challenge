package org.rokol.domain;

    import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.rokol.domain.model.Market;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

   // private ProductRepository productRepository = Mockito.mock(ProductRepositoryInMemoryImpl.class);

    @Mock
    private AbstractDaoFactory productRepository;

    private ProductService lists;

    @BeforeEach
    void init() {
        lists = new ProductServiceImpl(productRepository);
    }

    @Test
    void getMarketAndStack() {

    }
}
