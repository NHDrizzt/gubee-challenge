package org.rokol.domain;

import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.rokol.domain.model.Market;
import org.rokol.domain.model.Stack;
import org.rokol.domain.ports.spi.ProductRepository;
import org.rokol.quarkus.adapter.repository.ProductRepositoryJdbcImpl;
import org.rokol.quarkus.adapter.repository.ProductRepositoryProxyImpl;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepositoryProxyImpl.class);

    @BeforeEach
    void init() {

    }

    @Test
    void getMarketAndStack() {
        List<Market> marketList = new ArrayList<>();
        marketList.add(new Market(1, "Ecommerce"));
        List<Stack> stackList = new ArrayList<>();
        marketList.add(new Market(1, "Java"));
        var list = productRepository.listProductByMarketAndStack(marketList, stackList);
    }
}
