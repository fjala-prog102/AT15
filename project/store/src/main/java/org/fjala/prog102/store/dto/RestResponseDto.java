package org.fjala.prog102.store.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

public class RestResponseDto<T> {

    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    private T data;

    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    private List<String> errors;
}