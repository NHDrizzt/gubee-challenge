package org.rokol.quarkus.adapter.repository;

import org.rokol.domain.ports.spi.ProductRepository;
import org.rokol.domain.exception.DbException;
import org.rokol.domain.model.Market;
import org.rokol.domain.model.Product;
import org.rokol.domain.model.Stack;
import org.rokol.quarkus.adapter.repository.model.ConnectionProvider;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Alternative
@RequestScoped
public class ProductRepositoryJdbcImpl implements ProductRepository, ConnectionProvider {

    @Override
    public Connection establishConnection() {
        return DbConnection.getConnection();
    }

    @Transaction
    @Override
    public Set<Product> listProductByMarketAndStack(List<Market> listMarket, List<Stack> listStack) {
        Set<Product> listProduct = new LinkedHashSet<>();
        try (Connection conn = establishConnection()){

            PreparedStatement psMarket = conn.prepareStatement(selectedMarket(listMarket));
            PreparedStatement psStack = conn.prepareStatement(selectedStack(listStack));
            listProduct.addAll(createResulSet(psMarket));
            listProduct.addAll(createResulSet(psStack));
        }
        catch(SQLException e) {
            throw new DbException(e.getMessage());
        }
        return listProduct;
    }

    private Set<Product> createResulSet(PreparedStatement psStatement) {
        Set<Product> setProd = new LinkedHashSet<>();
        try {
            ResultSet rsMarket = psStatement.executeQuery();
            while(rsMarket.next()) {
                Product p = new Product(
                        rsMarket.getInt(1),
                        rsMarket.getString(2),
                        rsMarket.getString(3)
                );
                setProd.add(p);
            }
            rsMarket.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return setProd;
    }

    private String selectedMarket(List<Market> listMarket) {
        return String.format("select a.* from myjdbc.produto as a, myjdbc.market as b where a.id = b.produto_id and b.name in (%s) group by id,name,description",
                listMarket.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("','", "'", "'")));
    }

    private String selectedStack(List<Stack> listStack) {
        return String.format("select a.* from myjdbc.produto as a, myjdbc.stack as c where a.id = c.produto_id and c.name in  (%s)  group by id,name,description",
                listStack.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining("','", "'", "'")));
    }
}
