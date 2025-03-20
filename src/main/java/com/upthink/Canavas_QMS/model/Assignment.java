package com.upthink.Canavas_QMS.model;import gson.GsonDTO;import jakarta.persistence.*;import java.math.BigInteger;import java.sql.Timestamp;@Entity@Table(name = "assignment")public class Assignment {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    private int id;  // Modified from String to int    @Column(name = "course_id")    private String courseId;    @Column(name = "created_at", updatable = false)    private Timestamp createdAt;    @Column(name = "updated_at")    private Timestamp updatedAt;    @Column(name = "deleted_at")    private Timestamp deletedAt;    // New fields    @Column(name = "due_date")    private Long dueDate;    @Column(name = "lock_date")    private Long lockDate;    @Column(name = "grade_type")    private String gradeType;    @Column(name = "points_possible")    private BigInteger pointsPossible;    @Column(name = "rubric_based_grading")    private Boolean rubricBasedGrading;    @Column(name = "rubric", columnDefinition = "jsonb")    private String rubric;    @Column(name = "submission_started")    private Boolean submissionStarted;    @Column(name = "assignment_id")    private String assignmentId;    public int getId() {        return id;    }    public String getCourseId() {        return courseId;    }    public Timestamp getCreatedAt() {        return createdAt;    }    public Timestamp getUpdatedAt() {        return updatedAt;    }    public Timestamp getDeletedAt() {        return deletedAt;    }    public Long getDueDate() {        return dueDate;    }    public Long getLockDate() {        return lockDate;    }    public String getGradeType() {        return gradeType;    }    public BigInteger getPointsPossible() {        return pointsPossible;    }    public Boolean getRubricBasedGrading() {        return rubricBasedGrading;    }    public String getRubric() {        return rubric;    }    public Boolean getSubmissionStarted() {        return submissionStarted;    }    public String getAssignmentId() {        return assignmentId;    }}