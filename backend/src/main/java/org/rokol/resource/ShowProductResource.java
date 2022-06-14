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
import java.util.LinkedHashSet;
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

    @GET
    public List<Market> list() {
        //TODO still testing
        return Market.listAll();
    }
}