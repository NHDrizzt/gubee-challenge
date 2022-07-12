package org.rokol.application.adapters.resources;

import org.rokol.domain.dto.FilterProduct;
import org.rokol.domain.model.Product;
import org.rokol.domain.ports.interfaces.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/showProduct")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ShowProductResource {

    @Inject
    private ProductService productService;


    @Path("/listTest")
    @POST
    public Set<Product> getListMarketAndStackTest(FilterProduct filterProduct){
        System.out.println("chegou no resource!");
        return productService.getMarketAndStack(filterProduct.getMarket(), filterProduct.getStack());
    }

}
