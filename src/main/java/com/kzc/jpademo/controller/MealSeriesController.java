package com.kzc.jpademo.controller;

import com.kzc.jpademo.entity.CommonResult;
import com.kzc.jpademo.entity.MealSeries;
import com.kzc.jpademo.service.MealSeriesService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MealSeriesController {
    @Autowired
    private MealSeriesService mealSeriesService;

    @ApiOperation(value="查询所有菜系",httpMethod = "GET")
    @GetMapping(value = "/demo/findAll")
    public CommonResult findAll() {
        CommonResult result = new CommonResult();
        try {  
            List<MealSeries> list = mealSeriesService.findAll();
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @ApiOperation(value="添加菜系",httpMethod = "POST")
    @PostMapping(value = "/demo/saveMealSeries")
        public CommonResult saveMealSeries(@RequestBody MealSeries mealSeries) {
        CommonResult result = new CommonResult();
        try {
            mealSeriesService.saveMealSeries(mealSeries);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @ApiOperation(value="删除菜系",httpMethod = "DELETE")
    @DeleteMapping(value = "/demo/deleteMealSeries")
    public CommonResult deleteMealSeriesById(Integer mId) {
        CommonResult result = new CommonResult();
        try {
            mealSeriesService.deleteMealSeries(mId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @ApiOperation(value="更新菜系",httpMethod = "PUT")
    @PutMapping(value = "/demo/updateMealSeries")
    public CommonResult updateMealSeriesById(Integer id,String name) {
        CommonResult result = new CommonResult();
        try {
            mealSeriesService.updateMealSeriesById(id, name);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @ApiOperation(value="根据名称查询菜系",httpMethod = "GET")
    @GetMapping(value = "/demo/findByName")
    public CommonResult findByName(String name) {
        CommonResult result = new CommonResult();
        try {
            List<MealSeries> list = mealSeriesService.findBymName(name);
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @ApiOperation(value="降序查询粤菜",httpMethod = "GET")
    @GetMapping(value = "/demo/findByDesc")
    public CommonResult findByDesc(MealSeries mealSeries) {
        CommonResult result = new CommonResult();
        try {
            List<MealSeries> list = mealSeriesService.getMealSeriesByDesc(mealSeries);
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }

    @ApiOperation(value="分页查询id大于2的菜系",httpMethod = "GET")
    @GetMapping(value = "/demo/findByPage")
    public CommonResult findByPage(Integer pageNum) {
        CommonResult result = new CommonResult();
        try {
            List<MealSeries> list = mealSeriesService.getMealSeriesByPage(pageNum);
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
}
