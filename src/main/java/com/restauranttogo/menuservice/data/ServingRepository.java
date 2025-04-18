package com.restauranttogo.menuservice.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restauranttogo.menuservice.domain.ServingPo;

@Transactional
@Repository
public interface ServingRepository extends ServingBaseRepository<ServingPo>, JpaRepository<ServingPo,Long>{
	public <T extends ServingPo> T findFirstByName(String name);
	@Query("select s from ServingPo s where s.name like %:keyword%")
	public List<ServingPo> findByQuery(@Param("keyword")String searchQuery);
}