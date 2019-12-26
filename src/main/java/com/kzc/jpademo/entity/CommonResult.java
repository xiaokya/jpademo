package com.kzc.jpademo.entity;

import java.util.List;

public class CommonResult {
    private Integer state;
    private String msg;
    private List<MealSeries> data;
    public CommonResult() {
        this.state=200;
        this.msg="成功";
    }

    public CommonResult(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public CommonResult(Integer state, String msg, List<MealSeries> data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(List<MealSeries> data) {
        this.data = data;
    }
}
