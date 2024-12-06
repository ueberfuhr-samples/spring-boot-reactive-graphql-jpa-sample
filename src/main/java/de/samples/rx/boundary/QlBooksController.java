package de.samples.rx.boundary;

import de.samples.rx.boundary.model.QlBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class QlBooksController {

  @QueryMapping("findAllBooks")
  public Flux<QlBookDto> findAllBooks() {
    return Flux.empty();
  }

}
