package com.crmSystem.crm_backend.Repository;

import com.crmSystem.crm_backend.Collections.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
@RestController
//extend from mongo repository, able to do CURD actions
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {

}
