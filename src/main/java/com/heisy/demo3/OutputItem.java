package com.heisy.demo3;

public class OutputItem {

    private String data;

    public OutputItem(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return "data: " + data;
    }

}