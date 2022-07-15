package org.rokol.quarkus.adapter.config;

import org.rokol.quarkus.adapter.repository.model.AbstractDaoFactory;
import org.rokol.domain.usecase.ProductServiceImpl;
import org.rokol.domain.ports.api.ProductService;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Dependent
public class BeanConfiguration {

    @Default
    public ProductService abstractDaoFactory(AbstractDaoFactory abstractDaoFactory){
        return new ProductServiceImpl(abstractDaoFactory);
    }
}
