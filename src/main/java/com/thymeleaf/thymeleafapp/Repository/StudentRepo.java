package com.thymeleaf.thymeleafapp.Repository;

import com.thymeleaf.thymeleafapp.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

@Service
@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
    @Query(value = "select count(*) from student u where u.name =:name AND u.department = :department AND u.updated_by = :updatedBy AND u.updated_on = :updatedOn", nativeQuery = true)
    int countStudent(@Param("department") String department, @Param("name") String name, @Param("updatedBy") String updatedBy, @Param("updatedOn") String updatedOn);

    @Query(value = "select id from student u where u.name =:name  AND u.department = :department AND u.updated_by = :updatedBy AND u.updated_on = :updatedOn", nativeQuery = true)
    int findStudent(@Param("department") String department, @Param("name") String name, @Param("updatedBy") String updatedBy, @Param("updatedOn") String updatedOn);

    @Query(value = "select * from student u where u.name LIKE %:search% OR u.department LIKE %:search% OR u.updated_by LIKE %:search%", nativeQuery = true)
    List<Student> search(@Param("search") String search);
}
