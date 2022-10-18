
package com.esspl.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Table(name = "role")

@Data
public class Role {

	@Id
	private int id;
	private String name;
	

}
