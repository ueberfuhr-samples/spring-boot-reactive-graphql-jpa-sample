package de.samples.rx.boundary.scalars;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.StringValue;
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
import java.util.UUID;
import java.util.regex.Pattern;

@Configuration
public class UuidScalarConfiguration {

  private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
  private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);

  @Bean
  RuntimeWiringConfigurer registerUuidScalar() {
    return builder -> builder
      .scalar(
        GraphQLScalarType
          .newScalar()
          .name("UUID")
          .description("Java UUID scalar")
          .coercing(new UuidScalar())
          .build()
      );
  }

  private static class UuidScalar implements Coercing<UUID, String> {

    @SuppressWarnings("NullableProblems")
    @Override
    public String serialize(
      Object dataFetcherResult,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingSerializeException {
      if (dataFetcherResult instanceof UUID uuid) {
        return uuid.toString();
      } else {
        throw new CoercingSerializeException("Expected a UUID object.");
      }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public UUID parseValue(
      Object input,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingParseValueException {
      if (input instanceof String s) {
        if (!UUID_PATTERN.matcher(s).matches()) {
          throw new CoercingParseValueException("Invalid UUID: " + s);
        }
        return UUID.fromString(s);
      } else {
        throw new CoercingParseValueException("Expected a String");
      }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public UUID parseLiteral(
      Value<?> input,
      CoercedVariables variables,
      GraphQLContext graphQLContext,
      Locale locale
    ) throws CoercingParseLiteralException {
      if (input instanceof StringValue s) {
        return parseValue(s.getValue(), graphQLContext, locale);
      } else {
        throw new CoercingParseLiteralException("Expected a StringValue.");
      }
    }

  }

}
