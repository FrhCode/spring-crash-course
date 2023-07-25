package com.example.demo.algorithm.sorting;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSort implements SortingAlgorithm {
    @Override
    public int[] sort(int[] numbers) {
        return numbers;
    }
}
