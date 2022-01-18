package com.example.movieReserve.domain;

/**
 * {description}
 * date 2022/01/18
 *
 * @author eunheechoi
 */
public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
