package com.restauranttogo.menuservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restauranttogo.menuservice.domain.MenuPo;

@Repository
public interface MenuRepository extends JpaRepository<MenuPo,Long>{
	
}
