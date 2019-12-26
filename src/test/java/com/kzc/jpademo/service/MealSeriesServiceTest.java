//package com.kzc.jpademo.service;
//
//import com.kzc.jpademo.JpademoApplication;
//import com.kzc.jpademo.dao.MealSeriesDao;
//import com.kzc.jpademo.entity.CommonResult;
//import com.kzc.jpademo.entity.MealSeries;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JpademoApplication.class)
//@WebAppConfiguration
//public class MealSeriesServiceTest {
//    @InjectMocks
//    private MealSeriesService mealSeriesService;
//    @Mock
//    private MealSeriesDao mealSeriesDao;
//    private MealSeries mealSeries;
//    private Boolean flag = true;
//    private Integer mId = 3;
//    private String mName = "测试";
//    private List<MealSeries> mealSeriesList = new ArrayList<MealSeries>();
//    @Before
//    public void init(){
//        mealSeries = new MealSeries(mId,mName);
//        mealSeriesList.add(mealSeries);
//    }
//    @Test
//    public void findAllTest(){
//        Mockito.when(mealSeriesDao.findAll()).thenReturn(mealSeriesList);
//        List<MealSeries> list = mealSeriesService.findAll();
//        Assert.assertTrue(list.get(0).getmId().equals(mealSeries.getmId()));
//        Assert.assertTrue(list.get(0).getmName().equals(mealSeries.getmName()));
//    }
//    @Test
//    public void saveMealSeriesTest(){
//        Mockito.when(mealSeriesDao.save(mealSeries)).thenReturn(mealSeries);
//        Assert.assertTrue(flag.equals(mealSeriesService.saveMealSeries(mealSeries)));
//    }
//    @Test
//    public void deleteMealSeriesTest(){
//        Mockito.when(mealSeriesDao.findByMName(mName)).thenReturn(mealSeriesList);
//        mealSeriesService.deleteMealSeries(mId);
//        Assert.assertTrue(flag.equals(mealSeriesService.deleteMealSeries(mId)));
//    }
//    @Test
//    public void updateMealSeriesByIdTest(){
//        Mockito.when(mealSeriesDao.findByMName(mName)).thenReturn(mealSeriesList);
//        mealSeriesService.updateMealSeriesById(mId, mName);
//        Assert.assertTrue(flag.equals(mealSeriesService.updateMealSeriesById(mId,mName)));
//    }
//    @Test
//    public void findByNameTest(){
//        Mockito.when(mealSeriesDao.findByMName(mName)).thenReturn(mealSeriesList);
//        List<MealSeries> list = mealSeriesService.findBymName(mName);
//        Assert.assertTrue(list.get(0).getmId().equals(mealSeries.getmId()));
//        Assert.assertTrue(list.get(0).getmName().equals(mealSeries.getmName()));
//    }
//    @Test
//    public void findByDescTest(){
//
//    }
//    @Test
//    public void findByPageTest(){
//
//    }
//}
