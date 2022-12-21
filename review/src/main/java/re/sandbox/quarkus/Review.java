package re.sandbox.quarkus;

import lombok.Builder;
import lombok.Data;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

@Data
@Builder
public class Review {

    @Id
    @NonNull
    private String id;

    private String comment;

    private Product product;
}
