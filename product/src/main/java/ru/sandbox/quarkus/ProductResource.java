package ru.sandbox.quarkus;

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
        Product first = Product.builder().id("1").name("first").price(BigDecimal.ONE).build();
        Product second = Product.builder().id("2").name("second").price(BigDecimal.TEN).build();
        PRODUCTS.add(first);
        PRODUCTS.add(second);
    }

    @Query
    public Product product(@Id @NonNull String id) {
        return PRODUCTS.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    @Query
    public List<Product> allProducts() {
        return PRODUCTS;
    }
}
