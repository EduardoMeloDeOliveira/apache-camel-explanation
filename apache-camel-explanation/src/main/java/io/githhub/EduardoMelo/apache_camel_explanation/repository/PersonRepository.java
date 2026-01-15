package io.githhub.EduardoMelo.apache_camel_explanation.repository;

import io.githhub.EduardoMelo.apache_camel_explanation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
