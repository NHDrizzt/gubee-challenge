package org.rokol.services;

import org.rokol.dao.AbstractDaoFactory;
import org.rokol.dao.MarketRepository;
import org.rokol.dao.ProductRepository;
import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    AbstractDaoFactory abstractDaoFactory;

    ProductRepository productRepository;

    @Inject
    MarketRepository marketRepository;

    @Override
    public Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
        productRepository = abstractDaoFactory.createDatabase();
        return productRepository.listProductByMarketAndStack(listMarket, listStack);
    }

    @Override
    public List<Market> listAllMarkets(){
        return marketRepository.listAll();
    }
}
