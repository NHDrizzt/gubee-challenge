package org.rokol.domain;
import org.rokol.quarkus.adapter.repository.model.AbstractDaoFactory;
import org.rokol.domain.ports.spi.ProductRepository;
import org.rokol.domain.ports.api.ProductService;
import org.rokol.domain.model.Market;
import org.rokol.domain.model.Product;
import org.rokol.domain.model.Stack;
import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {

    private final AbstractDaoFactory abstractDaoFactory;

    public ProductServiceImpl(AbstractDaoFactory abstractDaoFactory) {
        this.abstractDaoFactory = abstractDaoFactory;
    }


    @Override
    public Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
        System.out.println("chegou no service");
        ProductRepository productRepository = abstractDaoFactory.createDatabase();
        return productRepository.listProductByMarketAndStack(listMarket, listStack);
    }
}
