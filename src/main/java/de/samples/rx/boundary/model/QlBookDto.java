package de.samples.rx.boundary.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data class QlBookDto {

  private String isbn;
  private String title;
  private final List<QlAppraisalDto> appraisals = new ArrayList<>();

}
