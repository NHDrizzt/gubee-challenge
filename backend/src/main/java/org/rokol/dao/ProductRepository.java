package org.rokol.dao;

import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;

import java.util.List;
import java.util.Set;

public interface ProductRepository {

    Set<Product> listProductByMarketAndStack(List<Market> listMarket, List<Stack> listStack);
}
