package com.DAO;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reviews {

    private ISO8601Utils iso8601DateFormat;
    private int score;
    private String user_id;
    private double sentiment;
    private String text;
    private int voted_total;
    private int voted_helpful;
    private String user_gender;
    private String user_name;
    private String summary;

    public Reviews() {

    }
}