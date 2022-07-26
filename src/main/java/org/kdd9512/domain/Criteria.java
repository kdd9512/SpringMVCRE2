package org.kdd9512.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Criteria { // 검색의 기준을 설정하기 위한 클래스.

    private int pageNum;
    private int amount;

    public Criteria() {
        this(1,10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

}
