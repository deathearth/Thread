package com.mst;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Question implements Comparable<Question>{

    private Long questionId;

    private BigInteger simHash;

    private Integer distance;

    @Override
    public int compareTo(Question o) {
        return  o.distance.compareTo(this.distance);
    }
}
