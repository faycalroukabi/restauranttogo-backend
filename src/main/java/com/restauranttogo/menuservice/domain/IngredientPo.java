package com.restauranttogo.menuservice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="INGREDIENTS")
public class IngredientPo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "INGREDIENT_ID")
	private Long identifier;
	@Column(name = "INGREDIENT_NAME" , unique = true)
	private String name;
	@Column(name = "INGREDIENT_TYPE")
	private String type;
	@ManyToMany(mappedBy="ingredients", fetch = FetchType.EAGER)
	private List<ServingPo> servings = new ArrayList<>();
	public IngredientPo(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
}
