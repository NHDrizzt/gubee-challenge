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
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/showProduct")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShowProductResource {

    @Inject
    AbstractDaoFactory abstractDaoFactory;
    @Inject
    ProductService productService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Set<Product> getMarketAndStack(List<Market> listMarket, List<Stack> listStack) throws SQLException {
        abstractDaoFactory = TypeDatabase.JDBC.getDefaultFactory();
        productService = new ProductServiceImpl(abstractDaoFactory);
        List<Market> marketList = new ArrayList<>();
        List<Stack> stackList = new ArrayList<>();
        Market market = new Market(1, "ERP");
        Stack stack = new Stack(1, "Java 10");
        Set<Product> set;
        marketList.add(market);
        stackList.add(stack);
        set = productService.getMarketAndStack(marketList, stackList);
        return set;
    }
}