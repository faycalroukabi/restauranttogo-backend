package com.restauranttogo.menuservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restauranttogo.menuservice.domain.IngredientPo;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientPo, Long>{
	public IngredientPo findByName(String string);
}
