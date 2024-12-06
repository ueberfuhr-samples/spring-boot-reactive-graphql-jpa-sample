package de.samples.rx.boundary.scalars;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.Locale;

@Configuration
public class VoidScalarConfiguration {

  @Bean
  RuntimeWiringConfigurer registerVoidScalar() {
    return builder -> builder
      .scalar(
        GraphQLScalarType
          .newScalar()
          .name("Void")
          .description("Java Void scalar")
          .coercing(new VoidScalar())
          .build()
      );
  }


  private static class VoidScalar implements Coercing<Void, String> {

    @SuppressWarnings("NullableProblems")
    @Override
    public String serialize(
      Object dataFetcherResult,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingSerializeException {
      return "";
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Void parseValue(
      Object input,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingParseValueException {
      return null;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Void parseLiteral(
      Value<?> input,
      CoercedVariables variables,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingParseLiteralException {
      return null;
    }

  }

}
