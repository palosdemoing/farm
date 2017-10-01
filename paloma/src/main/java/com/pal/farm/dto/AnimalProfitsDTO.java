package com.pal.farm.dto;


import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Data;


@NoArgsConstructor
@Data
public class AnimalProfitsDTO implements Serializable, Comparable<AnimalProfitsDTO> {

	private static final long serialVersionUID = 8920720499595714726L;
	
	private String animalClass;
	
	private String animalType;
	
	private Double profits;

    
    @Override
    public int compareTo(AnimalProfitsDTO o) {
        if (profits < o.profits) {
            return -1;
        }
        if (profits > o.profits) {
            return 1;
        }
        return 0;
    }
    
}
