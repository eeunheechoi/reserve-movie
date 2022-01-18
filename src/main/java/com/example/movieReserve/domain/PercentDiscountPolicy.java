package com.example.movieReserve.domain;

import java.time.Duration;

/**
 * {description}
 * date 2022/01/18
 *
 * @author eunheechoi
 */
public class PercentDiscountPolicy extends DiscountPolicy{
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }


    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
