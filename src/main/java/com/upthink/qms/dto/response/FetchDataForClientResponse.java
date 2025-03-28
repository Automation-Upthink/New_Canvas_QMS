package com.upthink.qms.dto.response;import java.sql.Timestamp;import java.util.List;public class FetchDataForClientResponse {    private final List<DataForClientDTO> fetchDataForClient;    public FetchDataForClientResponse(List<DataForClientDTO> fetchDataForClient) {        this.fetchDataForClient = fetchDataForClient;    }    public static class DataForClientDTO {        private final Integer clientId;        private final String courseId;        private final Integer assignmentRowId;        private final String assignmentId;        private final Timestamp dueDate;        private final Timestamp lockDate;        // Constructor used in JPQL constructor expression        public DataForClientDTO(Integer clientId, String courseId, Integer assignmentRowId, String assignmentId, Timestamp dueDate, Timestamp lockDate) {            this.clientId = clientId;            this.courseId = courseId;            this.assignmentRowId = assignmentRowId;            this.assignmentId = assignmentId;            this.dueDate = dueDate;            this.lockDate = lockDate;        }        // Getters and Setters        public Integer getClientId() {            return clientId;        }        public String getCourseId() {            return courseId;        }        public String getAssignmentId() {            return assignmentId;        }        public Integer getAssignmentRowId() {            return assignmentRowId;        }        public Timestamp getDueDate() {            return dueDate;        }        public Timestamp getLockDate() {            return lockDate;        }    }}