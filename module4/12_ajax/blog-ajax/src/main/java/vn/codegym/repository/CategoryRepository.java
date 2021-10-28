package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Category;

public interface CategoryRepository extends JpaRepository<Category ,Integer> {
    @Query("select p from Category p where p.id=:id1")
    Category findOne(@Param("id1") long id);
}
