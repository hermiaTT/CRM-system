package com.crmSystem.crm_backend.Repository;

import com.crmSystem.crm_backend.Collections.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByCustomerId(Long customerId);
    List<Service> findByEmployeeId(Long employeeId);
}
