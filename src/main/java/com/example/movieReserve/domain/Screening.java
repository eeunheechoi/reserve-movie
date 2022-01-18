package com.example.movieReserve.domain;

import java.time.LocalDateTime;

/**
 * {1.예매하라 메시지에 응답할 수 있어야 한다.
 *  2.책임이 결정 되었으므로 책임을 수행하는 데 필요한 인스턴스 변수를 결정한다.
 *  3.Movie에 가격을 계산하라 메시지를 전송해야 한다.
 *  }
 * date 2022/01/17
 *
 * @author eunheechoi
 */
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        //이 메시지는 수신자인 Movie 가 아니라 송신자인 Screening 의 의도를 표현한다.
        //Screening 이 Movie 의 내부 구현에 대한 어떤 지식도 없이 전송할 메시지를 결정했다.
        //Movie 의 내부 구현을 캡슐화 할 수 있다.
        //메시지가 변경되지 않는 한 Movie 에 어떤 수정을 가하더라도 Screening 에 영향을 미치지 않는다.
        //이로 인해 Screening 와 Movie 의 결합도는 낮다.
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

}
