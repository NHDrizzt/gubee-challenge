package org.rokol.application.adapters.resources;

import org.rokol.domain.model.FilterProduct;
import org.rokol.domain.model.Product;
import org.rokol.domain.ports.api.ProductService;

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
        return productService.getMarketAndStack(filterProduct.getMarket(), filterProduct.getStack());
    }

}
