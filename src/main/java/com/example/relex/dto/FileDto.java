package com.example.relex.dto;

import com.example.relex.validator.OperationParameter;
import com.example.relex.validator.OperationURL;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {

    @NonNull
    @JsonProperty("file_path")
    private String filepath;

    @Null(groups = {OperationURL.class})
    @NotNull(groups = {OperationParameter.class})
    private Operation operation;

}
