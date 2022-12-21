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
        REVIEWS.add(new Review("1", "text", new Product("1")));
        REVIEWS.add(new Review("2", "text", new Product("2")));
    }

    @Query
    public @NonNull Review review(@Id @NonNull String id) {
        return REVIEWS.stream().filter(r -> r.getId().equals(id)).findFirst().orElseThrow();
    }

    @Query
    public List<Review> allReviews() {
        return List.copyOf(REVIEWS);
    }
}
