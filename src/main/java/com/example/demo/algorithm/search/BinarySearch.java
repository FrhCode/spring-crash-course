package com.example.demo.algorithm.search;

import com.example.demo.algorithm.sorting.SortingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearch {
    @Autowired
    private SortingAlgorithm sortingAlgorithm;

    public BinarySearch(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public int search(int[] numbers, int numberToSearchTo){
        int[] sortedNumber = sortingAlgorithm.sort(numbers);

        //  Searching
        return 3;
    }
}
