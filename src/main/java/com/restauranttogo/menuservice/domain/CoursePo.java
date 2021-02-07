package com.restauranttogo.menuservice.domain;

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
@Table(name="COURSES")
public class CoursePo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name = "COURSE_ID")
	private Long identifier;
	@Column(name = "COURSE_TITLE")
	private String title;
	@Column(name = "COURSES_NUMBER")
	private Integer courses;
	@ManyToMany
	@JoinTable(name = "SERVINGS_PER_COURSE", 
		joinColumns = @JoinColumn(name="SERVING_ID"), 
		inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
	private List<ServingPo> servings;
	@ManyToMany(mappedBy = "courses")
	private List<MenuPo> menus;
	
}
