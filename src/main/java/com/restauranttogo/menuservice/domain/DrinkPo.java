package com.restauranttogo.menuservice.domain;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DrinkPo extends ServingPo{
	
	@Column(name="DRINK_VOL")
	private Double volume;
	@Column(name="DRINK_IS_ALCOHOLIC")
	private Boolean alcoholic;
}
