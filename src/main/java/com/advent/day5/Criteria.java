package com.advent.day5;

import java.util.List;

public interface Criteria<T> {
    List<T> meetCriteria(List<T> lines);
}
