package de.samples.rx.boundary.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

public @Data class QlAppraisalInputDto {

  @NotNull
  @Size(min = 3, max = 300)
  private String title;
  @NotNull
  @Pattern(regexp = "VERY_BAD|BAD|FINE|GOOD|VERY_GOOD")
  private String rating;

}
