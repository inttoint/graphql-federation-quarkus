package re.sandbox.quarkus;

import io.smallrye.graphql.api.federation.Extends;
import io.smallrye.graphql.api.federation.External;
import io.smallrye.graphql.api.federation.Key;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

import static re.sandbox.quarkus.Product.Fields.id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public @Extends @Key(fields = id) class Product {

    @Id
    @NonNull
    private @External String id;
}
