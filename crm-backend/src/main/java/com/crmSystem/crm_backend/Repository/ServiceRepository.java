package com.crmSystem.crm_backend.Repository;

import com.crmSystem.crm_backend.Collections.Services;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Services, ObjectId> {
}
