package com.example.movieReserve.domain;

/**
 * {description}
 * date 2022/01/18
 *
 * @author eunheechoi
 */
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening Screening);

}
