package com.example.HBIKataGame.entites;

import lombok.Data;
import lombok.ToString;


import javax.validation.constraints.NotNull;
import java.io.Serializable;


    @ToString
    @Data

    public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
        private String name;
        private int gameScore ;
        private int setScore ;
        private boolean duce;
        private boolean avantage;
        private boolean tieBreak;
        private boolean gagneLeSet;



}
