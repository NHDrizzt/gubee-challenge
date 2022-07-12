package org.rokol.quarkus.adapter.repository;

import org.rokol.domain.ports.repositories.ProductRepository;
import org.rokol.quarkus.adapter.repository.model.AbstractDaoFactory;

public class ProductRepositoryInMemoryFactory implements AbstractDaoFactory {

    @Override
    public ProductRepository createDatabase() {
        return new ProductRepositoryInMemory();
    }
}
