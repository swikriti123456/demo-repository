package com.demo.springmvc.beans;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

/*@Getter
@Setter()
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
@Entity
@Data  ///all (setter ,getter,construction in ones)
public class Student {
	@Id
	@Min(value=1)
	private int rollNo;
	/*@NotEmpty(message="sname is mandatory field")*/
	@Pattern(regexp="^[A-Z][a-z]{3,}$",message="name must be 4 character")
	private String sname;
	@Min(value=5,message="minimum age should be 5")
	@Max(value=100,message="maximum value should be 100")
	/*@Size(min=5,max=100)*/
	private int age;
	
 
}
