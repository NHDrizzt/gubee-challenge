package org.rokol.domain.ports.repositories;

import org.rokol.domain.model.Market;
import org.rokol.domain.model.Product;
import org.rokol.domain.model.Stack;

import java.util.List;
import java.util.Set;

public interface ProductRepository {

    Set<Product> listProductByMarketAndStack(List<Market> listMarket, List<Stack> listStack);
}
