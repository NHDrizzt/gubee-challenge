package org.rokol.dao;



import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class ProductRepositoryJdbcFactory implements AbstractDaoFactory {

    @Override
    public ProductRepository createDatabase() {
        return new ProductRepositoryProxy(new ProductRepositoryJdbc());
    }
}