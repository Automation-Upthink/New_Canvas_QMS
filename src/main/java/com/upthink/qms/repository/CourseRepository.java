package com.upthink.qms.repository;import com.upthink.qms.model.Course;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Modifying;import org.springframework.data.jpa.repository.Query;import org.springframework.data.repository.query.Param;import org.springframework.security.core.parameters.P;import org.springframework.stereotype.Repository;import org.springframework.transaction.annotation.Transactional;import java.sql.Timestamp;import java.util.List;import java.util.Optional;@Repositorypublic interface CourseRepository extends JpaRepository<Course, Integer> {    // Custom SQL Queries (excluding soft-deleted records)    @Query("SELECT c FROM Course c WHERE c.deletedAt IS NULL")    List<Course> findAllCourses();    @Query("SELECT c FROM Course c WHERE c.id = :id AND c.deletedAt IS NULL")    Optional<Course> findCourseById(Integer id);    @Modifying    @Transactional    @Query(value = "UPDATE course SET deleted_at = NOW() WHERE id = :id", nativeQuery = true)    void softDeleteCourseById(@Param("id") Integer id);    @Modifying    @Transactional    @Query(value = "UPDATE Course c SET c.name = :name, c.sla = :sla WHERE c.id = :id", nativeQuery = true)    void updateCourse(@Param("id") int id, @Param("name") String name, @Param("sla") long sla);    @Query(value = """            SELECT course.* FROM course            JOIN client            ON course.client_id=client.id            WHERE course.deleted_at is NULL AND client.id=:id            """, nativeQuery = true)    List<Course> getActiveCoursesForClient(@Param("id") int id);    @Modifying    @Transactional    @Query(value = """            INSERT INTO course            (course_id, client_id, created_at)            VALUES(:courseId, :clientId, NOW());            """, nativeQuery = true)    void saveCourseToDatabase(@Param("courseId") String courseId, @Param("clientId") int clientId);//    @Modifying//    @Transactional//    @Query(value = """//        INSERT INTO course (name, created_at)//        VALUES (:name, NOW())""", nativeQuery = true)//    int createCourse(@Param("clientId") clientId, @Param("courseId") String courseId)}