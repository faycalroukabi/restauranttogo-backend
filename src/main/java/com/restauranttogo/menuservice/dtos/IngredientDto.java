package com.restauranttogo.menuservice.dtos;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredientDto {

	private String name;
	private String type;
}
