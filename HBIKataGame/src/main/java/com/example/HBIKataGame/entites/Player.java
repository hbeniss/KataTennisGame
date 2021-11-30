package com.example.HBIKataGame.entites;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;


    @ToString
    @Data
    public class Player {
        @NotNull
        private String name;
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private int index;
        private int gameScore ;
        private int setScore ;
        private boolean duce;
        private boolean avantage;
        private boolean tieBreak;
        private boolean gagneLeSet;



}
