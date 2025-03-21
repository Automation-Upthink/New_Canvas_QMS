package com.upthink.Canavas_QMS.service;import com.upthink.Canavas_QMS.model.Person;import com.upthink.Canavas_QMS.repository.PersonRepository;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.util.List;import java.util.Optional;import jakarta.persistence.EntityNotFoundException;import java.io.PrintStream;import java.util.Collections;import java.util.List;import java.util.Optional;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;@Servicepublic class PersonService {    private final PersonRepository personRepository;    @Autowired    public PersonService(PersonRepository personRepository) {        this.personRepository = personRepository;    }    public Optional<Person> findPersonByEmail(String email) {        return this.personRepository.findByEmail(email);    }    public Optional<Person> findPersonById(String id) {        return this.personRepository.findById(id);    }    public List<Person> findPersonsByGroup(String group) {        return this.personRepository.findByGroup(group);    }    public Person findByCognitoId(String id) {        Optional<Person> personOpt = this.personRepository.findByCognitoId(id);        return !personOpt.isPresent() ? null : (Person)personOpt.get();    }    public List<Person> getAllUsersForManager() {        return this.personRepository.findAllExcludingManagerAndSuperAdmin();    }    public List<Person> getAllUsers() {        return this.personRepository.findAllUsers();    }    public List<Person> findAllByCognitoIds(List<String> cognitoIds) {        return this.personRepository.findByCognitoIdIn(cognitoIds);    }    @Transactional    public Person savePerson(Person person) {        System.out.println("Saving in to database initiated ...");        return (Person)this.personRepository.save(person);    }    @Transactional    public Person addGroup(String email, String newGroup) {        Optional<Person> personOpt = this.personRepository.findByEmail(email);        if (personOpt.isPresent()) {            Person person = (Person)personOpt.get();            person.setGroups(Collections.singletonList(newGroup));            return (Person)this.personRepository.save(person);        } else {            return null;        }    }    public Person toggleActiveStatus(String email) {        Optional<Person> personOptional = this.personRepository.findByEmail(email);        if (personOptional.isPresent()) {            Person person = (Person)personOptional.get();            PrintStream var10000 = System.out;            boolean var10001 = !person.isActive();            var10000.println("Person active status : " + var10001);            person.setActive(!person.isActive());            return (Person)this.personRepository.save(person);        } else {            throw new EntityNotFoundException("Person with email " + email + " not found");        }    }}//@Service//public class PersonService {////    private final PersonRepository personRepository;////    public PersonService(PersonRepository personRepository) {//        this.personRepository = personRepository;//    }////    public List<Person> getAllPersons() {//        return personRepository.findAllPersons();//    }////    public Optional<Person> getPersonById(String id) {//        return personRepository.findPersonById(id);//    }//////    @Transactional////    public void savePerson(Person person) {////        personRepository.insertPerson(////                person.getId(),////                person.getName(),////                person.getEmail(),////                person.getCognitoId(),////                person.getGroups(),////                person.isActive(),////                person.getPhoneNumber(),////                person.getUserName()////        );////    }////////    @Transactional////    public void deletePerson(String id) {////        personRepository.deletePersonById(id);////    }//}