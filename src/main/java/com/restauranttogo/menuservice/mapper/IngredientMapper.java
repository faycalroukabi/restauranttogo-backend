package com.restauranttogo.menuservice.mapper;

import com.restauranttogo.menuservice.domain.IngredientPo;
import com.restauranttogo.menuservice.domain.ServingPo;
import com.restauranttogo.menuservice.dtos.IngredientDto;
import com.restauranttogo.menuservice.dtos.ServingDto;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public IngredientDto convertToDto(IngredientPo ingredientPo) {

        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setName(ingredientPo.getName());
        ingredientDto.setType(ingredientPo.getType());
        return ingredientDto;
    }
}
