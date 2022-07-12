package org.rokol.domain.ports.api;

import org.rokol.domain.model.Market;
import org.rokol.domain.model.Product;
import org.rokol.domain.model.Stack;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack);

}
