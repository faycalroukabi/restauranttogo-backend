package com.restauranttogo.menuservice.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	@Column(name = "INGREDIENT_NAME")
	private String name;
	@Column(name = "INGREDIENT_TYPE")
	private String type;
	@ManyToMany(mappedBy="ingredients")
	private List<ServingPo> servings;
	public IngredientPo(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
}
