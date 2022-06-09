package org.rokol.services;

import org.rokol.dao.AbstractDaoFactory;
import org.rokol.dao.ProductRepository;
import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@RequestScoped
public class ProductServiceImpl implements ProductService {

    @Inject
    ProductRepository productRepository;

    public ProductServiceImpl(AbstractDaoFactory factory) {
        productRepository = factory.createDatabase();
    }
    @Override
    public Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
        return productRepository.listProductByMarketAndStack(listMarket, listStack);
    }
}
