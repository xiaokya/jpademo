package com.kzc.jpademo.dao;

import com.kzc.jpademo.entity.MealSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MealSeriesDao extends JpaRepository<MealSeries,Integer>,JpaSpecificationExecutor<MealSeries> {
    List<MealSeries> findByMName(String name);
    @Modifying
    @Transactional
    @Query(value = "update meal_series set m_name=?2 where m_id=?1",nativeQuery = true)
    void updateMealSeriesById(Integer id, String name);
}
