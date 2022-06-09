package org.rokol.dao;

import org.rokol.annotation.Transaction;
import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RequestScoped
public class ProductRepositoryProxy implements ProductRepository {

    @Inject
    ProductRepository productRepository;

    public ProductRepositoryProxy(ProductRepository productRepository) {
        Objects.requireNonNull(productRepository, "productRepository is required");
        this.productRepository = productRepository;
    }

    @Override
    public Set<Product> listProductByMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
        Set<Product> listProducts = null;
        try {
            Arrays.stream(this.productRepository.getClass().getMethods()).filter(it -> it.isAnnotationPresent(Transaction.class)).findAny().ifPresent(it -> {
                System.out.println("Iniciando execucao do metodo " + it.getName());
            });
            listProducts = productRepository.listProductByMarketAndStack(listMarket, listStack);
        }
        catch(Exception e){
            System.out.println("Finalizando execucao do metodo com erro " + e.getMessage());
        }
        finally {
            System.out.println("Finalizando execução do metodo com sucesso");
        }
        return Objects.requireNonNullElse(listProducts, Set.of());
    }
}
