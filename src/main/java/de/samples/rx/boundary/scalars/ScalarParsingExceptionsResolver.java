package de.samples.rx.boundary.scalars;

import graphql.GraphQLError;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component // TODO Does not work for scalars
public class ScalarParsingExceptionsResolver extends DataFetcherExceptionResolverAdapter {

  @Override
  protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof CoercingParseValueException
      || ex instanceof CoercingParseLiteralException
    ) {
      return GraphQLError
        .newError()
        .errorType(ErrorType.BAD_REQUEST)
        .message(ex.getMessage())
        .path(env.getExecutionStepInfo().getPath())
        .location(env.getField().getSourceLocation())
        .build();
    }
    return super.resolveToSingleError(ex, env);
  }

}
