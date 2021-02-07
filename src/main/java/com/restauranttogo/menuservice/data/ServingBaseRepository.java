package com.restauranttogo.menuservice.data;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.restauranttogo.menuservice.domain.ServingPo;


@NoRepositoryBean
public interface ServingBaseRepository<T extends ServingPo> extends Repository<T, Long>{
	
}
