package com.restauranttogo.menuservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restauranttogo.menuservice.domain.DrinkPo;

@Transactional
@Repository
public interface DrinkRepository extends ServingBaseRepository<DrinkPo>, JpaRepository<DrinkPo,Long> {

}
