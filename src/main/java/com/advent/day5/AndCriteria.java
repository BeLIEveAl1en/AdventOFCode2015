package com.advent.day5;

import java.util.List;

public class AndCriteria<T> implements Criteria<T>{

    private final Criteria<T> criteria1;
    private final Criteria<T> criteria2;

    public AndCriteria(Criteria<T> criteria1, Criteria<T> criteria2) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
    }

    @Override
    public List<T> meetCriteria(List<T> lines) {
        return criteria2.meetCriteria(criteria1.meetCriteria(lines));
    }
}
