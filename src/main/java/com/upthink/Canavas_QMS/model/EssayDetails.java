package com.upthink.Canavas_QMS.model;import gson.GsonDTO;import jakarta.persistence.*;import java.sql.Timestamp;@Entity@Table(name = "essay_details")public class EssayDetails {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    private int id;    @Column(name = "person_id")    private String personId;    @Column(name = "essay_id")    private String essayId;    @Column(name = "user_action")    private String userAction;    @Column(name = "created_at", updatable = false)    private Timestamp createdAt;    @Column(name = "updated_at")    private Timestamp updatedAt;    @Column(name = "deleted_at")    private Timestamp deletedAt;    @Column(name = "downloaded_at")    private Timestamp downloadedAt;    // No-args constructor for JPA    protected EssayDetails() {}}