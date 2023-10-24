package com.advent.day5;

import java.util.List;

public class AndCriteriaForThreeElements implements Criteria{
    private final Criteria criteria1;
    private final Criteria criteria2;
    private final Criteria criteria3;

    public AndCriteriaForThreeElements(Criteria criteria1, Criteria criteria2, Criteria criteria3) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
        this.criteria3 = criteria3;
    }

    @Override
    public List<Line> meetCriteria(List<Line> lines) {
        List<Line> criteriaLines1 = criteria1.meetCriteria(lines);
        List<Line> criteriaLines2 = criteria2.meetCriteria(criteriaLines1);
        return criteria3.meetCriteria(criteriaLines2);
    }
}
