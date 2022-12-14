package com.example.relex.controller;

import com.example.relex.dto.*;
import com.example.relex.service.ListService;
import com.example.relex.validator.OperationParameter;
import com.example.relex.validator.OperationURL;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "/file")
public class FileController {

    private final ListService listService;

    @GetMapping("/get_max_value")
    @ApiOperation("Find the maximum value from the passed file")
    public ResponseEntity<MaxDto> getMax(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMax(fileDto));
    }

    @GetMapping("/get_min_value")
    @ApiOperation("Find the minimum value from the passed file")
    public ResponseEntity<MinDto> getMin(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMin(fileDto));
    }

    @GetMapping("/get_mean_value")
    @ApiOperation("Find the mean value from the passed file")
    public ResponseEntity<MeanDto> getMean(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMean(fileDto));
    }

    @GetMapping("/get_median_value")
    @ApiOperation("Find the median value from the passed file")
    public ResponseEntity<MedianDto> getMedian(@RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getMedian(fileDto));
    }

    @GetMapping("/get_longest_increasing_sequence")
    @ApiOperation("Find all longest increasing sequences in a given file")
    public ResponseEntity<IncreasingSequenceDto> getLongestIncreasingSequence(
            @RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getLongestIncreasingSequence(fileDto));
    }

    @GetMapping("/get_longest_decreasing_sequence")
    @ApiOperation("Find all longest decreasing sequences in a given file")
    public ResponseEntity<DecreasingSequenceDto> getLongestDecreasingSequence(
            @RequestBody @Validated(OperationURL.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getLongestDecreasingSequence(fileDto));
    }

    @GetMapping()
    @ApiOperation("Perform the operation passed in the request body")
    public ResponseEntity<Value> getValue(@RequestBody @Validated(OperationParameter.class) FileDto fileDto) {
        return ResponseEntity.ok(listService.getValue(fileDto));
    }


}
