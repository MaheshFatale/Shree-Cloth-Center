package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "Shop_Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NotBlank(message="Company-Name is Mandatory")
	@Size(min=5,max=15,message="Name Size 5 To 15")
	private String brandName;
	
	
	@NotBlank(message="Type is Mandatory")
	@Size(min=4,max=10,message="Name Size 5 To 10")
	private String type;
	
	
	@NotBlank(message="Size is Mandatory")
	@Size(min=1,max=5,message="Size in (S,M,L,XL,XXL,XXXL)")
	private String size;
	
	@NotNull(message="Price is Mandatory")
	@Positive(message="Price MUST be POSITIVE")
	private Double price;
	
	@CreationTimestamp
	@Column(name = "Created_Date" ,updatable = false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(name = "Update_Date" ,insertable = false)
	private LocalDate updateDate;
}
