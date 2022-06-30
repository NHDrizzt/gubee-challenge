package org.rokol.dao;


import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class ProductRepositoryJdbcFactory implements AbstractDaoFactory {


    @Override
    public ProductRepository createDatabase() {
        return new ProductRepositoryProxy(new ProductRepositoryJdbc());
    }
}