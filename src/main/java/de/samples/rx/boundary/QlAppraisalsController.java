package de.samples.rx.boundary;

import de.samples.rx.boundary.model.QlAppraisalDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class QlAppraisalsController {

  @QueryMapping("findAppraisalByUuid")
  public Mono<QlAppraisalDto> findByUUID(
    @NotNull
    @Argument
    UUID uuid
  ) {
    return Mono.empty();
  }

}
