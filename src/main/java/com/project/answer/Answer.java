package com.project.answer;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Answer {
    private boolean result;
    private String error;
    private Date date;

    public Answer(boolean result, String error) {
        this.result = result;
        this.error = error;
        this.date = new Date();
    }

    public Answer(boolean result) {
        this.result = result;
        this.date = new Date();
        this.error = "no error";
    }
}