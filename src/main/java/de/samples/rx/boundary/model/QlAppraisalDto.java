package de.samples.rx.boundary.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

public @Data class QlAppraisalDto {

  private UUID uuid;
  private String title;
  private String rating;
  private LocalDateTime published;

}
