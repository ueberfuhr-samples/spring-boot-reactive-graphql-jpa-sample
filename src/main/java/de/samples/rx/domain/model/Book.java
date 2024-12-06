package de.samples.rx.domain.model;

import de.samples.rx.shared.validation.Isbn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Builder
public @Data class Book {

  @NotNull
  @Isbn
  private String isbn;
  @NotNull
  @Size(min = 3, max = 100)
  private String title;
  @Builder.Default
  private Collection<Appraisal> appraisals = new ArrayList<>();

}
