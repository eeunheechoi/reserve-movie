package com.example.movieReserve.domain;

/**
 * {description}
 * date 2022/01/17
 *
 * @author eunheechoi
 */
public class SequenceCondition implements DiscountCondition{
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
