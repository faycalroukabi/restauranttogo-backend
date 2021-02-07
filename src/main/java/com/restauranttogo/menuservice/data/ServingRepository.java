package com.restauranttogo.menuservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restauranttogo.menuservice.domain.ServingPo;

@Transactional
@Repository
public interface ServingRepository extends ServingBaseRepository<ServingPo>, JpaRepository<ServingPo,Long>{
	public <T extends ServingPo> T findFirstByName(String name);
}