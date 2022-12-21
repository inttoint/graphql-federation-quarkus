package ru.sandbox.quarkus;

import io.smallrye.graphql.api.federation.Key;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

import java.math.BigDecimal;

import static ru.sandbox.quarkus.Product.Fields.id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public @Key(fields = id) class Product {

    @Id
    @NonNull
    private String id;

    private String name;

    private BigDecimal price;
}
