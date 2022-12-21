package re.sandbox.quarkus;

import lombok.Builder;
import lombok.Data;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

@Data
@Builder
public class Product {

    @Id
    @NonNull
    private String id;
}
