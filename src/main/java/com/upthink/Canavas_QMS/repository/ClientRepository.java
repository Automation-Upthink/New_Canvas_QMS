package com.upthink.Canavas_QMS.repository;import com.upthink.Canavas_QMS.model.Client;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Modifying;import org.springframework.data.jpa.repository.Query;import org.springframework.stereotype.Repository;import org.springframework.transaction.annotation.Transactional;import java.sql.Timestamp;import java.util.List;import java.util.Optional;@Repositorypublic interface ClientRepository extends JpaRepository<Client, Integer> {    // Custom SQL Queries (excluding soft-deleted records)    @Query("SELECT c FROM Client c WHERE c.deletedAt IS NULL")    List<Client> findAllClients();    @Query("SELECT c FROM Client c WHERE c.id = :id AND c.deletedAt IS NULL")    Optional<Client> findClientById(Integer id);    @Modifying    @Transactional    @Query("UPDATE Client c SET c.deletedAt = :deletedAt WHERE c.id = :id")    void softDeleteClientById(Integer id, Timestamp deletedAt);}