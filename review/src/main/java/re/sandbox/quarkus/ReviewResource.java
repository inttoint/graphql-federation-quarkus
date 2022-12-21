package re.sandbox.quarkus;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

import java.util.ArrayList;
import java.util.List;

@GraphQLApi
public class ReviewResource {

    private static final List<Review> REVIEWS = new ArrayList<>();

    static {
        Product product1 = Product.builder().id("1").build();
        Review review1 = Review.builder().id("1").comment("text").product(product1).build();
        REVIEWS.add(review1);

        Product product2 = Product.builder().id("2").build();
        Review review2 = Review.builder().id("2").comment("text").product(product2).build();
        REVIEWS.add(review2);
    }

    @Query
    public Review review(@Id @NonNull String id) {
        return REVIEWS.stream().filter(r -> r.getId().equals(id)).findFirst().orElseThrow();
    }

    @Query
    public List<Review> allReviews() {
        return REVIEWS;
    }
}
