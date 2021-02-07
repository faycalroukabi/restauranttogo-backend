package com.restauranttogo.menuservice.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodPo extends ServingPo{
	@Column(name = "FOOD_AVG_WEIGHT")
	private Double averageWeight;
	@Column(name = "FOOD_SUFFICIENCY")
	private Integer sufficiency;
}
