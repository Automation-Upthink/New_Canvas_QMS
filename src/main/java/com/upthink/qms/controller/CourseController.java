package com.upthink.qms.controller;import com.upthink.qms.dto.request.*;import com.upthink.qms.dto.response.CourseResponse;import com.upthink.qms.model.Client;import com.upthink.qms.model.Course;import com.upthink.qms.service.ClientService;import com.upthink.qms.service.CourseService;import org.springframework.http.ResponseEntity;import org.springframework.security.access.prepost.PreAuthorize;import org.springframework.web.bind.annotation.*;import java.util.List;import java.util.Optional;@RestController@RequestMapping("/api/courses")public class CourseController {    private final CourseService courseService;    private final ClientService clientService;    public CourseController(CourseService courseService, ClientService clientService) {        this.courseService = courseService;        this.clientService = clientService;    }    @GetMapping    @PreAuthorize("hasAnyRole('QM_ADMIN', 'SME', 'USER')")    public ResponseEntity<List<Course>> getAllCourses(@RequestBody GetAllCoursesRequest request) {        List<Course> courses = courseService.getAllCourses();        return ResponseEntity.ok(courses);    }    @GetMapping("/{id}")    @PreAuthorize("hasAnyRole('QM_ADMIN', 'SME', 'USER')")    public ResponseEntity<Course> getCourseById(@PathVariable int id, @RequestBody GetCourseByIdRequest request) {        Optional<Course> course = courseService.getCourseById(id);        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());    }    @PostMapping("/listCoursesForClient")    @PreAuthorize("hasRole('QM_ADMIN')")    public ResponseEntity<CourseResponse> getCoursesByClient(@RequestBody GetClientByIdRequest request) {        System.out.println("Request: " + request);        Optional<Client> client = clientService.getClientById(request.getClientId());        if(client.isPresent()) {            CourseResponse courseResponse = courseService.getCoursesForAClient(client.get().getId());            return ResponseEntity.ok(courseResponse);        } else {            return ResponseEntity.notFound().build();        }    }//    @PostMapping//    @PreAuthorize("hasRole('QM_ADMIN')")//    public ResponseEntity<String> createCourse(@RequestBody CreateCourseRequest request) {//        courseService.saveCourse(request.getData());//        return ResponseEntity.ok("Course created successfully");//    }////    @PutMapping("/{id}")//    @PreAuthorize("hasRole('QM_ADMIN')")//    public ResponseEntity<String> updateCourse(@PathVariable int id, @RequestBody UpdateCourseRequest request) {//        Optional<Course> existingCourse = courseService.getCourseById(id);//        if (existingCourse.isPresent()) {//            Course course = request.getData();//            course.setId(id);//            courseService.saveCourse(course);//            return ResponseEntity.ok("Course updated successfully");//        } else {//            return ResponseEntity.notFound().build();//        }//    }////    @DeleteMapping("/{id}")//    @PreAuthorize("hasRole('QM_ADMIN')")//    public ResponseEntity<String> deleteCourse(@PathVariable int id, @RequestBody DeleteCourseRequest request) {//        Optional<Course> existingCourse = courseService.getCourseById(id);//        if (existingCourse.isPresent()) {//            Course course = existingCourse.get();//            course.setDeletedAt(new Timestamp(System.currentTimeMillis())); // Soft delete by updating deletedAt//            courseService.saveCourse(course);//            return ResponseEntity.ok("Course soft deleted successfully");//        } else {//            return ResponseEntity.notFound().build();//        }//    }}