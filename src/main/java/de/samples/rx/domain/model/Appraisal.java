package de.samples.rx.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public @Data class Appraisal {

  private UUID uuid;
  @NotNull
  @Size(min = 3, max = 300)
  private String title;
  @NotNull
  private Rating rating;
  private LocalDateTime published;

}
