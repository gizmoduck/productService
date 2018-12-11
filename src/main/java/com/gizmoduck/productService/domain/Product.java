package com.gizmoduck.productService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The meaning of annotations:
*  1. @Entity tell spring boot JPA to treat this class as an entity and persist it the database.
*  2. @Builder – this lmobok annotation adds builder method to our class for creating objects using builder pattern.
*  3. @AllArgsConstructor – this lmobok annotation adds an all arguments constructor to the class, Builder method needs this method.
*  4. @NoArgsConstructor – this lmobok annotation adds a default constructor to the class, JPA needs this constructor to fetch the entities.
*  5. @Getter – this lombok annotation adds getters to all the fields in the class, this is required to fetch individual attributes of the product, this is also used by Jackson to serialise/deserialise the fields
*/
@Entity(name="product")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String sku;
	private String description;
	
}
