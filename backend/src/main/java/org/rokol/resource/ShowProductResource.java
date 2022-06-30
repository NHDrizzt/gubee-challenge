package org.rokol.resource;

import antlr.MakeGrammar;
import org.rokol.dao.AbstractDaoFactory;
import org.rokol.enums.TypeDatabase;
import org.rokol.model.FilterProduct;
import org.rokol.model.Market;
import org.rokol.model.Product;
import org.rokol.model.Stack;
import org.rokol.services.ProductService;
import org.rokol.services.ProductServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.stream.Collectors;

@Path("/showProduct")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShowProductResource {

    @Inject
    ProductService productService;

    @Path("/listTest")
    @POST
    public Set<Product> getListMarketAndStackTest(FilterProduct filterProduct){
        return productService.getMarketAndStack(filterProduct.getMarket(), filterProduct.getStack());
    }

    @Path("/listAllMarket")
    @GET
    public List<Market> getListAllMarkets(){
        return productService.listAllMarkets();
    }
}