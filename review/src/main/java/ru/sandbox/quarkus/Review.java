package ru.sandbox.quarkus;

import io.smallrye.graphql.api.federation.Provides;
import lombok.*;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @NonNull
    private String id;

    private String comment;

    @Provides(fields = "name")
    private Product product;
}
