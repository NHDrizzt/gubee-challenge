package org.rokol.resource;

import org.rokol.dao.AbstractDaoFactory;
import org.rokol.enums.TypeDatabase;
import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;
import org.rokol.services.ProductService;
import org.rokol.services.ProductServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Product> getListMarketAndStack(List<Market> listMrk){
        abstractDaoFactory = TypeDatabase.JDBC.getDefaultFactory();
        productService = new ProductServiceImpl(abstractDaoFactory);
        List<Market> listMarket = new ArrayList<>();
        List<Stack> listStack = new ArrayList<>();
        Set<Product> setProduct;

        listMarket.add(new Market(1,"Ecommerce"));
        listMarket.add(new Market(1,"ERP"));
        listStack.add(new Stack(1, "Java 10"));


        setProduct = productService.getMarketAndStack(listMarket, listStack);
        System.out.println(setProduct);
        return setProduct;
    }

    @Path("/listTest")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Product> getListMarketAndStackTest(List<Market> listMrk){
        abstractDaoFactory = TypeDatabase.JDBC.getDefaultFactory();
        productService = new ProductServiceImpl(abstractDaoFactory);
        List<Market> listMarket = new ArrayList<>();
        List<Stack> listStack = new ArrayList<>();
        Set<Product> setProduct;

        listMarket.add(new Market(1,"Ecommerce"));
        listMarket.add(new Market(1,"ERP"));
        listStack.add(new Stack(1, "Java 10"));


        setProduct = productService.getMarketAndStack(listMrk, listStack);
        System.out.println(setProduct);
        return setProduct;
    }


    @Path("/getAll")
    @GET
    public List<Market> list() {
        return productService.listAllMarkets();
    }
}