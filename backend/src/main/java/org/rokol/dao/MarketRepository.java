package org.rokol.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.rokol.model.Market;

public interface MarketRepository extends PanacheRepository<Market> {

}
