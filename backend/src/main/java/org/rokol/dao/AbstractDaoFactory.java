package org.rokol.dao;


public interface AbstractDaoFactory {

    public ProductRepository createDatabase();
}
