package com.vpetrou.cs.repositories;

import com.vpetrou.cs.models.Contact;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, String> {

    @Query(value = "{'email': ?0}", count = true)
    Long getEmailCount(String email);

    List<Contact> findByNameIgnoreCaseContaining(String name);
}
