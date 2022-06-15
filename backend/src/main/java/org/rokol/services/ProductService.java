package org.rokol.services;

import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack);

    List<Market> listAllMarkets();
}
