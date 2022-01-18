package com.example.movieReserve.domain;

import com.example.movieReserve.enums.MovieType;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * {description}
 * date 2022/01/17
 *
 * @author eunheechoi
 */
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    private DiscountPolicy discountPolicy;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime,
                               Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        if (discountPolicy == null) {
            return fee;
        }
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    private boolean isDiscountable(Screening screening) {
        //Movie 는 DiscountCondition 에 할인 여부를 판단하라 메시지를 전송한다.
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    protected Money getFee() {
        return fee;
    }

}
