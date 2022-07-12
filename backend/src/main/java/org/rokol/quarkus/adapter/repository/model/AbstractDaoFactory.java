package org.rokol.quarkus.adapter.repository.model;


import org.rokol.domain.ports.spi.ProductRepository;

public interface AbstractDaoFactory {

    public ProductRepository createDatabase();
}
