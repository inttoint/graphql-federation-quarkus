package ru.sandbox.quarkus;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.ArrayList;
import java.util.List;

@GraphQLApi
public class ReviewResource {

    private static final List<Review> REVIEWS = new ArrayList<>();

    static {
        REVIEWS.add(new Review("1", "text", new Product("1", "first")));
        REVIEWS.add(new Review("2", "text", new Product("2", "second")));
        REVIEWS.add(new Review("3", "text", new Product("1", "first")));
    }

    @Query
    public List<Review> allReviews() {
        return List.copyOf(REVIEWS);
    }
}
