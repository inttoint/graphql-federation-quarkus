package ru.sandbox.quarkus;

import lombok.Builder;
import lombok.Data;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

import java.math.BigDecimal;

@Data
@Builder
public class Product {

    @Id
    @NonNull
    private String id;

    private String name;

    private BigDecimal price;
}
