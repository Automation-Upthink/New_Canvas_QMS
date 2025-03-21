package com.upthink.Canavas_QMS.repository;import com.upthink.Canavas_QMS.model.Person;import java.util.List;import java.util.Optional;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;import org.springframework.data.repository.query.Param;import org.springframework.stereotype.Repository;@Repositorypublic interface PersonRepository extends JpaRepository<Person, String> {    Optional<Person> findByEmail(String email);    @Query(            value = "SELECT * FROM person WHERE cognitoid = :id",            nativeQuery = true    )    Optional<Person> findByCognitoId(@Param("id") String id);    Optional<Person> findById(String id);    @Query(            value = "SELECT * FROM person p WHERE :group = ANY(p.groups)",            nativeQuery = true    )    List<Person> findByGroup(@Param("group") String group);    @Query(            value = "SELECT * FROM person WHERE cognitoid IN (:cognitoIds) ",            nativeQuery = true    )    List<Person> findByCognitoIdIn(@Param("cognitoIds") List<String> cognitoIds);    @Query(            value = "SELECT * FROM person WHERE NOT ('MANAGER' = ANY(groups) OR 'SUPERADMIN' = ANY(groups))",            nativeQuery = true    )    List<Person> findAllExcludingManagerAndSuperAdmin();    @Query(            value = "SELECT * FROM person",            nativeQuery = true    )    List<Person> findAllUsers();}