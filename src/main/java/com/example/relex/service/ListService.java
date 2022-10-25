package com.example.relex.service;

import com.example.relex.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

@Service
@RequiredArgsConstructor
public class ListService {

    private final FileService fileService;

    public Value getValue(FileDto fileDto) {
        return switch (fileDto.getOperation()) {
            case get_max_value -> getMax(fileDto);
            case get_min_value -> getMin(fileDto);
            case get_mean_value -> getMean(fileDto);
            case get_median_value -> getMedian(fileDto);
            case get_longest_increasing_sequence -> getLongestIncreasingSequence(fileDto);
            case get_longest_decreasing_sequence -> getLongestDecreasingSequence(fileDto);
        };
    }

    public MaxDto getMax(FileDto fileDto) {
        List<Integer> list = fileService.fileToList(fileDto.getFilepath());
        return new MaxDto(Collections.max(list));
    }

    public MinDto getMin(FileDto fileDto) {
        List<Integer> list = fileService.fileToList(fileDto.getFilepath());
        return new MinDto(Collections.min(list));
    }

    public MedianDto getMedian(FileDto fileDto) {
        List<Integer> list = fileService.fileToList(fileDto.getFilepath());
        Collections.sort(list);

        Double median;
        if (list.size() % 2 == 1)
            median = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        else {
            double lower = list.get(list.size() / 2 - 1);
            double upper = list.get(list.size() / 2);
            median = (lower + upper) / 2.0;
        }
        return new MedianDto(median);
    }

    public MeanDto getMean(FileDto fileDto) {
        List<Integer> list = fileService.fileToList(fileDto.getFilepath());
        Double mean = list.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
        return new MeanDto(mean);

    }

    public IncreasingSequenceDto getLongestIncreasingSequence(FileDto fileDto) {
        List<Integer> list = fileService.fileToList(fileDto.getFilepath());
        BiPredicate<Integer, Integer> predicate = (previous, current) -> previous < current;

        return new IncreasingSequenceDto(getLongestSequence(list, predicate));
    }

    public DecreasingSequenceDto getLongestDecreasingSequence(FileDto fileDto) {
        List<Integer> list = fileService.fileToList(fileDto.getFilepath());
        BiPredicate<Integer, Integer> predicate = (previous, current) -> previous > current;
        return new DecreasingSequenceDto(getLongestSequence(list, predicate));
    }

    private List<List<Integer>> getLongestSequence(List<Integer> list, BiPredicate<Integer, Integer> predicate) {
        List<List<Integer>> lists = new ArrayList<>();

        int fromIndex = -1;
        int toIndex = -1;

        int currentFrom = -1;
        int currentTo;

        for (int i = 1; i < list.size(); i++) {
            if (predicate.test(list.get(i - 1), list.get(i))) {
                if (currentFrom == -1)
                    currentFrom = i - 1;

                if (i == list.size() - 1) {
                    currentTo = list.size();

                    if (currentTo - currentFrom > toIndex - fromIndex) {
                        fromIndex = currentFrom;
                        toIndex = currentTo;
                    }
                }
            } else {
                currentTo = i;

                if (currentTo - currentFrom > toIndex - fromIndex) {
                    fromIndex = currentFrom;
                    toIndex = currentTo;
                }
                currentFrom = -1;
            }
        }

        if (fromIndex > -1) {
            lists.add(list.subList(fromIndex, toIndex));
        }
        return lists;
    }


}
