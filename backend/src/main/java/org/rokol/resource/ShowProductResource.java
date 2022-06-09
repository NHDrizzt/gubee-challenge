package org.rokol.resource;

import org.rokol.dao.AbstractDaoFactory;
import org.rokol.enums.TypeDatabase;
import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;
import org.rokol.services.ProductService;
import org.rokol.services.ProductServiceImpl;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/hello")
@Resource
public class ShowProductResource {

    @Inject
    AbstractDaoFactory abstractDaoFactory;
    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Set<Product> getMarketAndStack() throws SQLException {
        abstractDaoFactory = TypeDatabase.JDBC.getDefaultFactory();
        productService = new ProductServiceImpl(abstractDaoFactory);
        List<Market> marketList = new ArrayList<>();
        List<Stack> stackList = new ArrayList<>();
        Market market = new Market(1, "ERP");
        Stack stack = new Stack(1, "Java 10");
        marketList.add(market);
        stackList.add(stack);
        Set<Product> set;
        set = productService.getMarketAndStack(marketList, stackList);
        return set;
    }
}