package ru.sandbox.quarkus;

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

    private Product product;
}
