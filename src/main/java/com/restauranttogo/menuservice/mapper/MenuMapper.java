package com.restauranttogo.menuservice.mapper;

import com.restauranttogo.menuservice.domain.DrinkPo;
import com.restauranttogo.menuservice.domain.FoodPo;
import com.restauranttogo.menuservice.domain.MenuPo;
import com.restauranttogo.menuservice.domain.ServingPo;
import com.restauranttogo.menuservice.dtos.IngredientDto;
import com.restauranttogo.menuservice.dtos.MenuDto;
import com.restauranttogo.menuservice.dtos.ServingDto;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuMapper {


    @Autowired
    ServingMapper servingMapper;

    public MenuDto convertToDto(MenuPo menupo) {
        MenuDto menudto = new MenuDto();

    }
}
