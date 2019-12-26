package com.kzc.jpademo.service;

import com.kzc.jpademo.dao.MealSeriesDao;
import com.kzc.jpademo.entity.MealSeries;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealSeriesService {
    @Autowired
    private MealSeriesDao mealSeriesDao;

    public List<MealSeries> findAll() {
        return mealSeriesDao.findAll();
    }

    public Boolean saveMealSeries(MealSeries mealSeries) {
        mealSeriesDao.save(mealSeries);
        return true;
    }

    public Boolean deleteMealSeries(Integer mId) {
        mealSeriesDao.deleteById(mId);
        return true;
    }

    public Boolean updateMealSeriesById(Integer id, String name) {
        mealSeriesDao.updateMealSeriesById(id, name);
        return true;
    }

    public List<MealSeries> findBymName(String name) {
        return mealSeriesDao.findByMName(name);
    }

    // 动态查询
    public List<MealSeries> getMealSeriesByDesc(MealSeries mealSeries) {
        Specification<MealSeries> specification = new Specification<MealSeries>() {
            /**
             *
             * @param root  查询的对象属性的封装
             * @param criteriaQuery  封装了各个部分如select from
             * @param criteriaBuilder 查询条件的构造器
             * @return
             */
            @Nullable
            @Override
            public Predicate toPredicate(Root<MealSeries> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(criteriaBuilder.equal(root.get("mName"), "粤菜"));
                if (mealSeries.getmId() != null && !"".equals(mealSeries.getmId())) {
                    predicates.add(criteriaBuilder.gt(root.get("mId"), mealSeries.getmId()));
                }
                Predicate[] arr = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(arr));
            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "mId");
        List<MealSeries> mealSeriesList = mealSeriesDao.findAll(specification, sort);
        for (MealSeries mealSeries1 : mealSeriesList) {
            System.out.println(mealSeries1);
        }
        return mealSeriesList;
    }

    // 排序分页查询
    public List<MealSeries> getMealSeriesByPage(Integer pageNum) {
        Specification<MealSeries> specification = new Specification<MealSeries>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MealSeries> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.gt(root.get("mId"), 2);
                return predicate;
            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "mId");
        PageRequest pageRequest = PageRequest.of(pageNum, 2, sort);
        Page<MealSeries> page = mealSeriesDao.findAll(specification, pageRequest);
        // JpaSpecificationExecutor接口的count方法
        System.out.println("总记录数：" + mealSeriesDao.count(specification));
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前页码：" + (page.getNumber() + 1));
        System.out.println("当前页内容：" + page.getContent());
        System.out.println("当前页记录数：" + page.getNumberOfElements());
        return page.getContent();
    }
}
