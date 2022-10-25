package com.example.relex.service;

import com.example.relex.exceptions.FileNotFoundException;
import com.example.relex.exceptions.FileParsingException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    public List<Integer> fileToList(String filename) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
            return br.lines().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileNotFoundException();
        } catch (Exception e) {
            throw new FileParsingException();
        }
    }
}
