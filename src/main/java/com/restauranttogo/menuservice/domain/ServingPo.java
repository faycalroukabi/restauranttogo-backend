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
@Table(name = "SERVINGS")
@Inheritance
public class ServingPo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "SERVING_ID")
	private Long identifier;
	@Column(name = "SERVING_NAME" , unique = true)
	private String name;
	@Column(name = "SERVING_CALORIES")
	private Double calories;
	@Column(name = "SERVING_ORIGIN")
	private String countryOfOrigin;
	@ManyToMany
	@JoinTable(name = "INGREDIENTS_PER_SERVING", 
		joinColumns = @JoinColumn(name="INGREDIENT_ID"), 
		inverseJoinColumns = @JoinColumn(name="SERVING_ID"))
	private List<IngredientPo> ingredients = new ArrayList<>();
	@ManyToMany(mappedBy="servings",fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	private List<CoursePo> courses = new ArrayList<>();
	@ManyToMany(mappedBy="servings",fetch = FetchType.LAZY)
	private List<MenuPo> menus = new ArrayList<>();
	
}
