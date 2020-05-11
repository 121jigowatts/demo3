package com.heisy.demo3;

public class InputItem {

    private String data;

    public InputItem(String data) {
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