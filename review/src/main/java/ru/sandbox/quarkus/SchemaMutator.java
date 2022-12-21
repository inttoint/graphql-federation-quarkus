package ru.sandbox.quarkus;

import graphql.schema.*;
import io.smallrye.graphql.api.federation.Key;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLObjectType.newObject;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

@ApplicationScoped
public class SchemaMutator {

    private static final String KEY = Key.class.getSimpleName();

    public GraphQLSchema.Builder transform(@Observes GraphQLSchema.Builder schemaBuilder) {
        final GraphQLSchema rawSchema = schemaBuilder.build();
        Set<GraphQLType> types = rawSchema.getAdditionalTypes().stream().map(this::mutateSubgraphTypes).collect(toSet());

        return schemaBuilder.clearAdditionalTypes().additionalTypes(types);
    }

    private GraphQLType mutateSubgraphTypes(GraphQLType type) {
        if (type instanceof GraphQLObjectType objectType && hasKeyDirective(objectType))
            return newObject(objectType).replaceDirectives(modifyDirectives(objectType.getDirectives())).build();

        return type;
    }

    private List<GraphQLDirective> modifyDirectives(List<GraphQLDirective> directives) {
        return directives.stream()
                .map(directive -> {
                    if (directive.getName().equalsIgnoreCase(KEY)) {
                        var arguments = directive.getArguments().stream().map(this::modifyArguments).toList();
                        return GraphQLDirective.newDirective(directive).replaceArguments(arguments).build();
                    }
                    return directive;
                })
                .toList();
    }

    private GraphQLArgument modifyArguments(GraphQLArgument argument) {
        if (argument.getName().equals("fields")) {
            Object value = argument.getArgumentValue().getValue();
            if (value instanceof Object[] args) {
                String argsString = Arrays.stream(args).map(String.class::cast).collect(joining(" "));
                return newArgument(argument).type(GraphQLString).value(argsString).build();
            }
        }
        return argument;
    }

    private static boolean hasKeyDirective(GraphQLObjectType type) {
        return type.getDirectives().stream()
                .anyMatch(directive -> directive.getName().equalsIgnoreCase(KEY));
    }
}
