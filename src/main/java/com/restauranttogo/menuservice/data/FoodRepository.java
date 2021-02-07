package com.restauranttogo.menuservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restauranttogo.menuservice.domain.FoodPo;

@Transactional
@Repository
public interface FoodRepository extends ServingBaseRepository<FoodPo>, JpaRepository<FoodPo, Long>{

}
