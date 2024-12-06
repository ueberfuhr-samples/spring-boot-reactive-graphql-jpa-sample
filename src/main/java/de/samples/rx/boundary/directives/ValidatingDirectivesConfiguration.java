package de.samples.rx.boundary.directives;

import graphql.validation.rules.OnValidationErrorStrategy;
import graphql.validation.rules.ValidationRules;
import graphql.validation.schemawiring.ValidationSchemaWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class ValidatingDirectivesConfiguration {

  @Bean
  public RuntimeWiringConfigurer validatingDirectives(CustomMessageInterpolator messageInterpolator) {
    final var validationRules = ValidationRules
      .newValidationRules()
      .onValidationErrorStrategy(OnValidationErrorStrategy.RETURN_NULL)
      .messageInterpolator(messageInterpolator)
      .build();
    final var schemaWiring = new ValidationSchemaWiring(validationRules);
    return builder -> builder
      .directiveWiring(schemaWiring)
      .build();
  }


}