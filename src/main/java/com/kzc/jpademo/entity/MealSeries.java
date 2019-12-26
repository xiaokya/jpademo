package com.kzc.jpademo.entity;

import javax.persistence.*;

@Table
@Entity
public class MealSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mId;
    @Column
    private String mName;

    public MealSeries() { }
    public MealSeries(String mName) {
        this.mName=mName;
    }
    public MealSeries(Integer mId,String mName) {
        this.mId=mId;
        this.mName=mName;
    }
    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "MealSeries{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }
}
