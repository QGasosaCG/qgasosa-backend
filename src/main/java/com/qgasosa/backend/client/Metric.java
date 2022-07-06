package com.qgasosa.backend.client;

public class Metric {
    private String text;
    private Integer value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "text='" + text + '\'' +
                ", value=" + value +
                '}';
    }
}
