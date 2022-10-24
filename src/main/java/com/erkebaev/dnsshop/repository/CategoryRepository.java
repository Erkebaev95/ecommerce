package com.erkebaev.dnsshop.repository;

import com.erkebaev.dnsshop.dto.CategoryDto;
import com.erkebaev.dnsshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.is_activated = true and c.is_deleted = false")
    List<Category> findAllByActivated();


    /*User*/
    @Query("select new com.erkebaev.dnsshop.dto.CategoryDto(c.id, c.name, count(p.category.id)) " +
            "from Category c inner join Product p on p.category.id = c.id " +
            " where c.is_activated = true and c.is_deleted = false group by c.id")
    List<CategoryDto> getCategoryAndProduct();
}
