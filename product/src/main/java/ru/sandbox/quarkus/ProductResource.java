package ru.sandbox.quarkus;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@GraphQLApi
public class ProductResource {

    private static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        PRODUCTS.add(new Product("1", "first", BigDecimal.ONE));
        PRODUCTS.add(new Product("2", "second", BigDecimal.TEN));
    }

    @Query
    @NonBlocking
    public Uni<Product> product(@Id @NonNull String id) {
        Product product = PRODUCTS.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
        return Uni.createFrom().item(product);
    }

    @Query
    public List<Product> allProducts() {
        return List.copyOf(PRODUCTS);
    }
}
