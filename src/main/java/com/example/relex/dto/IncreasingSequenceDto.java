package com.example.relex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncreasingSequenceDto implements Value {

    @JsonProperty("increasing_sequence")
    private List<List<Integer>> sequence;

}
