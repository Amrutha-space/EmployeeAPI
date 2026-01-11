package com.example.employeeapi.spec;

import com.example.employeeapi.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpec {

    public static Specification<EmployeeEntity> nameContains(String name) {
        return (root, query, cb) ->
                name == null ? null :
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<EmployeeEntity> genderEquals(String gender) {
        return (root, query, cb) ->
                gender == null ? null :
                        cb.equal(root.get("gender"), gender);
    }
}
