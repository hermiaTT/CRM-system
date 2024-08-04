package com.crmSystem.crm_backend.Repository;

import com.crmSystem.crm_backend.Collections.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
