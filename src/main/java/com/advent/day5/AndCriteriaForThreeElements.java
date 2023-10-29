package com.advent.day5;

import java.util.List;

public class AndCriteriaForThreeElements implements Criteria<String>{
    private final Criteria<String> criteria1;
    private final Criteria<String> criteria2;
    private final Criteria<String> criteria3;

    public AndCriteriaForThreeElements(Criteria<String> criteria1, Criteria<String> criteria2, Criteria<String> criteria3) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
        this.criteria3 = criteria3;
    }

    @Override
    public List<String> meetCriteria(List<String> lines) {
        List<String> criteriaLines1 = criteria1.meetCriteria(lines);
        List<String> criteriaLines2 = criteria2.meetCriteria(criteriaLines1);
        return criteria3.meetCriteria(criteriaLines2);
    }
}
