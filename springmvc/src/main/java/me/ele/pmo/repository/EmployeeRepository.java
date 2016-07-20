package me.ele.pmo.repository;

import me.ele.pmo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by kimi on 6/24/16.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee getByName(String name);

    @Query("SELECT e FROM Employee e where e.name = :name and e.gender = :gender")
    Employee get(@Param("name") String name, @Param("gender") String gender);
}
