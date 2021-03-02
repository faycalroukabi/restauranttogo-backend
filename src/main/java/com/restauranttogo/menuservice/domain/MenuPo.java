package com.restauranttogo.menuservice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="MENUS")
public class MenuPo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "MENU_ID")
	private Long identifier;
	@Column(name = "MENU_TITLE")
	private String title;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "COURSES_PER_MENU", 
			joinColumns = @JoinColumn(name="MENU_ID"), 
			inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
	private List<CoursePo> courses = new ArrayList<>();
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SERVINGS_PER_MENU", 
			joinColumns = @JoinColumn(name="MENU_ID"), 
			inverseJoinColumns = @JoinColumn(name="SERVING_ID"))
	private List<ServingPo> servings = new ArrayList<>();

}
