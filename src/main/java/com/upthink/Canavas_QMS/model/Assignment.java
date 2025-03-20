package com.upthink.Canavas_QMS.model;import gson.GsonDTO;import jakarta.persistence.Column;import jakarta.persistence.Entity;import jakarta.persistence.Id;import jakarta.persistence.Table;import java.sql.Timestamp;@Entity@Table(name = "assignment")public class Assignment extends GsonDTO {    @Id    @Column(name = "id", nullable = false)    private String id;    @Column(name = "course_id", nullable = false)    private String courseId;    @Column(name="created_at", nullable = false)    private Timestamp createdAt;    @Column(name="updated_at")    private Timestamp updatedAt;    @Column(name="deleted_at")    private Timestamp deletedAt;    protected Assignment() {}    public String getId() {        return id;    }    public String getCourseId() {        return courseId;    }    public Timestamp getCreatedAt() {        return createdAt;    }    public Timestamp getUpdatedAt() {        return updatedAt;    }    public Timestamp getDeletedAt() {        return deletedAt;    }}