package com.example.relex.controller;

import com.example.relex.dto.*;
import com.example.relex.service.ListService;
import com.example.relex.validator.OperationParameter;
import com.example.relex.validator.OperationURL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {

    private final ListService listService;

    @GetMapping("/get_max_value")
    public ResponseEntity<MaxDto> getMax(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMax(fileDto));
    }

    @GetMapping("/get_min_value")
    public ResponseEntity<MinDto> getMin(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMin(fileDto));
    }

    @GetMapping("/get_mean_value")
    public ResponseEntity<MeanDto> getMean(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMean(fileDto));
    }

    @GetMapping("/get_median_value")
    public ResponseEntity<MedianDto> getMedian(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMedian(fileDto));
    }

    @GetMapping("/get_longest_increasing_sequence")
    public ResponseEntity<IncreasingSequenceDto> getLongestIncreasingSequence(
            @RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getLongestIncreasingSequence(fileDto));
    }

    @GetMapping("/get_longest_decreasing_sequence")
    public ResponseEntity<DecreasingSequenceDto> getLongestDecreasingSequence(
            @RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getLongestDecreasingSequence(fileDto));
    }


    @GetMapping()
    public ResponseEntity<Value> getValue(@RequestBody @Validated(OperationParameter.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getValue(fileDto));
    }


}
