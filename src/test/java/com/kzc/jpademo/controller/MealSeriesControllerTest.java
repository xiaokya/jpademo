package com.kzc.jpademo.controller;


import com.google.gson.Gson;
import com.kzc.jpademo.JpademoApplication;
import com.kzc.jpademo.dao.MealSeriesDao;
import com.kzc.jpademo.entity.CommonResult;
import com.kzc.jpademo.entity.MealSeries;
import com.kzc.jpademo.service.MealSeriesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpademoApplication.class)
@WebAppConfiguration
public class MealSeriesControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void findAllTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/demo/findAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().toString());
    }
    @Test
    public void saveMealSeriesTest() throws Exception{
        MealSeries mealSeries = new MealSeries("测试");
        Gson gson = new Gson();
        String json = gson.toJson(mealSeries);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/demo/saveMealSeries")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().toString());
    }
    @Test
    public void deleteMealSeriesByIdTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/demo/deleteMealSeries")
                .param("mId","112"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().toString());
    }
    @Test
    public void updateMealSeriesByIdTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/demo/updateMealSeries")
                .param("id","24")
                .param("name","更新"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().toString());
    }
    @Test
    public void findByNameTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/demo/findByName")
                .param("name","粤菜"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().toString());
    }
    @Test
    public void findByDescTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/demo/findByDesc")
                .param("mId","3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().toString());
    }
    @Test
    public void findByPageTest() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/demo/findByPage")
                .param("pageNum","0"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(mvcResult.getResponse().toString());
    }
//    @InjectMocks
//    private MealSeriesController mealSeriesController;
//    @Mock
//    private MealSeriesService mealSeriesService;
//    private MealSeries mealSeries;
//    private Boolean flag = true;
//    private Integer mId = 1;
//    private String mName = "测试";
//    private List<MealSeries> mealSeriesList = new ArrayList<MealSeries>();
//    @Before
//    public void init(){
//        mealSeries = new MealSeries(mId,mName);
//        mealSeriesList.add(mealSeries);
//    }
//    @Test
//    public void findAllTest(){
//        Mockito.when(mealSeriesService.findAll()).thenReturn(mealSeriesList);
//        CommonResult result = mealSeriesController.findAll();
//        Assert.assertTrue(("成功").equals(result.getMsg()));
//    }
//    @Test
//    public void saveMealSeriesTest(){
//        Mockito.when(mealSeriesService.saveMealSeries(mealSeries)).thenReturn(flag);
//        CommonResult result = mealSeriesController.saveMealSeries(mealSeries);
//        Assert.assertTrue(("成功").equals(result.getMsg()));
//    }
//    @Test
//    public void deleteMealSeriesByIdTest(){
//        Mockito.when(mealSeriesService.deleteMealSeries(mId)).thenReturn(flag);
//        CommonResult result = mealSeriesController.deleteMealSeriesById(mId);
//        Assert.assertTrue(("成功").equals(result.getMsg()));
//    }
//    @Test
//    public void updateMealSeriesByIdTest(){
//        Mockito.when(mealSeriesService.updateMealSeriesById(mId, mName)).thenReturn(flag);
//        CommonResult result = mealSeriesController.updateMealSeriesById(mId, mName);
//        Assert.assertTrue(("成功").equals(result.getMsg()));
//    }
//    @Test
//    public void findByNameTest(){
//        Mockito.when(mealSeriesService.findBymName(mName)).thenReturn(mealSeriesList);
//        CommonResult result = mealSeriesController.findByName(mName);
//        Assert.assertTrue(("成功").equals(result.getMsg()));
//    }
//    @Test
//    public void findByDescTest(){
//        Mockito.when(mealSeriesService.getMealSeriesByDesc(mealSeries)).thenReturn(mealSeriesList);
//        CommonResult result =mealSeriesController.findByDesc(mealSeries);
//        Assert.assertTrue(("成功").equals(result.getMsg()));
//    }
//    @Test
//    public void findByPageTest(){
//        Mockito.when(mealSeriesService.getMealSeriesByPage(0)).thenReturn(mealSeriesList);
//        CommonResult result =mealSeriesController.findByPage(0);
//        Assert.assertTrue(("成功").equals(result.getMsg()));
//    }
}
