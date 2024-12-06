package de.samples.rx.boundary.model;

import de.samples.rx.shared.validation.Isbn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

public @Data class QlBookInputDto {

  @NotNull
  @Isbn
  private String isbn;
  @NotNull
  @Size(min = 3, max = 100)
  private String title;

}
