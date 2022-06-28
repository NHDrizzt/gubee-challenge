package org.rokol.enums;

import org.rokol.dao.AbstractDaoFactory;
import org.rokol.dao.ProductRepositoryInMemoryFactory;
import org.rokol.dao.ProductRepositoryJdbcFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


public enum TypeDatabase {
    JDBC(new ProductRepositoryJdbcFactory()),
    INMEMORY(new ProductRepositoryInMemoryFactory()),
    DEFAULT();

    private AbstractDaoFactory abstractFactory;

    TypeDatabase(AbstractDaoFactory factory) {
        this.abstractFactory = factory;
    }
    TypeDatabase() {

    }

    public AbstractDaoFactory getInstance() {
        return this.abstractFactory;
    }

    public AbstractDaoFactory getDefaultFactory() {
        return TypeDatabase.JDBC.getInstance();
    }
}
