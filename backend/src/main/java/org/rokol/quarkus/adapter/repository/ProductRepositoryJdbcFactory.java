package org.rokol.quarkus.adapter.repository;



import org.rokol.domain.ports.repositories.ProductRepository;
import org.rokol.quarkus.adapter.repository.model.AbstractDaoFactory;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ProductRepositoryJdbcFactory implements AbstractDaoFactory {

    @Override
    public ProductRepository createDatabase() {
        return new ProductRepositoryProxy(new ProductRepositoryJdbc());
    }
}
