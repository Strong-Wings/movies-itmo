package com.itmo.movies.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
    private int status;
    private String reason;
}
