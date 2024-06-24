package in.mahesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
