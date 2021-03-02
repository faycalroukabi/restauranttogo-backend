package com.restauranttogo.menuservice.services;

import java.util.ArrayList;
import java.util.List;

import com.restauranttogo.menuservice.domain.*;
import com.restauranttogo.menuservice.exception.ObjectNotFoundException;
import com.restauranttogo.menuservice.mapper.ServingMapper;
import com.restauranttogo.menuservice.tool.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restauranttogo.menuservice.data.DrinkRepository;
import com.restauranttogo.menuservice.data.FoodRepository;
import com.restauranttogo.menuservice.data.IngredientRepository;
import com.restauranttogo.menuservice.data.ServingRepository;
import com.restauranttogo.menuservice.dtos.DrinkDto;
import com.restauranttogo.menuservice.dtos.FoodDto;
import com.restauranttogo.menuservice.dtos.IngredientDto;
import com.restauranttogo.menuservice.dtos.ServingDto;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServingService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private ServingRepository servingRepository;
    @Autowired
    private ServingMapper servingMapper;

    public <T extends ServingPo> void mapCommunServing(ServingDto servingDto, T servingAbs) {
        ServingPo servingPo = servingAbs;
        servingPo.setIngredients(new ArrayList<>());
        servingDto.getIngredients().stream().forEach(ingredient -> {
            IngredientPo ingredientPo = ingredientRepository.findByName(ingredient.getName());
            servingPo.getIngredients().add(ingredientPo);
        });
        servingPo.setCalories(servingDto.getCalories());
        servingPo.setName(servingDto.getName());
        servingPo.setCountryOfOrigin(servingDto.getCountryOfOrigin());
    }

    public void mapServing(ServingDto servingDto) {
        if (servingDto instanceof FoodDto) {
            mapFood(servingDto);
        }
        if (servingDto instanceof DrinkDto) {
            mapDrink(servingDto);
        }
    }

    public ServingDto mapFood(ServingDto servingDto) {
        FoodPo foodPo = new FoodPo();
        foodPo.setAverageWeight(((FoodDto) servingDto).getAverageWeight());
        foodPo.setSufficiency(((FoodDto) servingDto).getSufficiency());
        mapCommunServing(servingDto, foodPo);
        foodPo = foodRepository.save(foodPo);
        return servingMapper.convertToDto(foodPo);
    }

    public ServingDto mapDrink(ServingDto servingDto) {
        DrinkPo drinkPo = new DrinkPo();
        drinkPo.setAlcoholic(((DrinkDto) servingDto).getAlcoholic());
        drinkPo.setVolume(((DrinkDto) servingDto).getVolume());
        mapCommunServing(servingDto, drinkPo);
        drinkPo = drinkRepository.save(drinkPo);
        return servingMapper.convertToDto(drinkPo);
    }

    public void mapIngredients(List<IngredientPo> ingredients) {
        ingredientRepository.saveAll(ingredients);
    }

    public <T extends ServingDto> List<T> mapAllDto() {
        List<ServingPo> servingPos = servingRepository.findAll();
        List<ServingDto> servingDtos = new ArrayList<>();
        servingPos.stream().forEach(servingPo -> {
            ServingDto servingDto = mapOneServingDto(servingPo);
            servingDtos.add(servingDto);
        });
        return (List<T>) servingDtos;
    }


    public <T extends ServingDto, S extends ServingPo> T mapOneServingDto(S servingPo) {
        ServingDto servingDto = new ServingDto();
        if (servingPo instanceof FoodPo) {
            servingDto = new FoodDto();
            ((FoodDto) servingDto).setAverageWeight(((FoodPo) servingPo).getAverageWeight());
            ((FoodDto) servingDto).setSufficiency(((FoodPo) servingPo).getSufficiency());
        }
        if (servingPo instanceof DrinkPo) {
            servingDto = new DrinkDto();
            ((DrinkDto) servingDto).setAlcoholic(((DrinkPo) servingPo).getAlcoholic());
            ((DrinkDto) servingDto).setVolume(((DrinkPo) servingPo).getVolume());
        }
        servingDto.setCountryOfOrigin(servingPo.getCountryOfOrigin());
        servingDto.setIdentifier(servingPo.getIdentifier());
        servingDto.setName(servingPo.getName());
        servingDto.setCalories(servingPo.getCalories());
        List<IngredientDto> ingredientDtos = new ArrayList<>();
        /*servingPo.getIngredients().stream().forEach(ingredientPo -> {
            IngredientDto ingredientDto = new IngredientDto();
            ingredientDto.setName(ingredientPo.getName());
            ingredientDto.setType(ingredientPo.getType());
            ingredientDtos.add(ingredientDto);
        });*/
        servingDto.setIngredients(ingredientDtos);

        return (T) servingDto;
    }

    public <T extends ServingDto, S extends ServingPo> T mapOneServingPo(T servingDto) {
        ServingPo servingPo = new ServingPo();
        if (servingDto instanceof FoodDto) {
            servingPo = new FoodPo();
            ((FoodPo) servingPo).setAverageWeight(((FoodDto) servingDto).getAverageWeight());
            ((FoodPo) servingPo).setSufficiency(((FoodDto) servingDto).getSufficiency());
        }
        if (servingDto instanceof DrinkDto) {
            servingPo = new DrinkPo();
            ((DrinkPo) servingPo).setAlcoholic(((DrinkDto) servingDto).getAlcoholic());
            ((DrinkPo) servingPo).setVolume(((DrinkDto) servingDto).getVolume());
        }
        servingPo.setCountryOfOrigin(servingDto.getCountryOfOrigin());
        servingPo.setName(servingDto.getName());
        servingPo.setCalories(servingDto.getCalories());
        List<IngredientPo> ingredientPos = new ArrayList<>();
        servingPo.getIngredients().stream().forEach(ingredientDto -> {
            IngredientPo ingredientPo = new IngredientPo();
            ingredientPo.setName(ingredientDto.getName());
            ingredientPo.setType(ingredientDto.getType());
            ingredientPos.add(ingredientPo);
        });
        servingPo.setIngredients(ingredientPos);

        return (T) mapOneServingDto(servingRepository.save(servingPo));
    }


  /*  public ServingDto getServingById(Long identifier) {
        ServingPo servingPo = servingRepository.getOne(identifier);
        return servingMapper.convertToDto(servingPo);
    }*/

    public <T extends ServingDto> T getServingByName(String name) {
        ServingPo servingPo = servingRepository.findFirstByName(name);
        if (servingPo != null)
            return mapOneServingDto(servingPo);

        return null;
    }

    public <T extends ServingDto> T getServingById(Long id) {
        Validate.notNull(id, "id must be not null");
        ServingPo servingPo = servingRepository.findByIdentifier(id);
        if (servingPo == null)
            throw new ObjectNotFoundException("Serving not found with id: " + id);

        return mapOneServingDto(servingPo);
    }
}
