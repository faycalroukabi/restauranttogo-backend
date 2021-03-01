package com.restauranttogo.menuservice.mapper;

import com.restauranttogo.menuservice.domain.DrinkPo;
import com.restauranttogo.menuservice.domain.FoodPo;
import com.restauranttogo.menuservice.domain.IngredientPo;
import com.restauranttogo.menuservice.domain.ServingPo;
import com.restauranttogo.menuservice.dtos.FoodDto;
import com.restauranttogo.menuservice.dtos.IngredientDto;
import com.restauranttogo.menuservice.dtos.ServingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
 @Component
public class ServingMapper {

     @Autowired
     IngredientMapper ingredientMapper;

    public ServingDto convertToDto(ServingPo servingPo) {
        ServingDto  servingDto = new ServingDto();
        servingPo.getIngredients().stream().forEach(ingredient -> {
            IngredientDto ingredientDto = ingredientMapper.convertToDto(ingredient);
            servingDto.getIngredients().add(ingredientDto);
        });
        servingDto.setCalories(servingPo.getCalories());
        servingDto.setName(servingPo.getName());
        servingDto.setCountryOfOrigin(servingPo.getCountryOfOrigin());
        
        return servingDto;
    }
}
