package com.DAO;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;

public class Reviews {

    private DateFormat iso8601DateFormat;
    private int score;
    private String user_id;
    private double sentiment;
    private String text;
    private int voted_total;
    private int voted_helpful;
    private String user_gender;
    private String user_name;
    private String summary;
}