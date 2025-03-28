package com.upthink.qms.dto.request;import gson.GsonDTO;import java.util.List;public class CanvasEssaysDTO extends GsonDTO {    public static class CanvasEssayDTO {        private String essayId;        private String name;        private String courseId;        private Integer assignmentId;        private String submissionId;        private String userId;        private String ungradedFileLink; // Presigned URL for the ungraded file        public CanvasEssayDTO(String essayId, String name, String courseId, Integer assignmentId, String submissionId, String userId, String ungradedFileLink) {            this.essayId = essayId;            this.name = name;            this.courseId = courseId;            this.assignmentId = assignmentId;            this.submissionId = submissionId;            this.userId = userId;            this.ungradedFileLink = ungradedFileLink;        }        // Getters and Setters        public String getCourseId() { return courseId; }        public Integer getAssignmentId() { return assignmentId; }        public String getEssayId() {            return essayId;        }        public String getSubmissionId() { return submissionId; }        public String getUserId() { return userId; }        public String getUngradedFileLink() { return ungradedFileLink; }        public String getName() {            return name;        }    }    List<CanvasEssayDTO> canvasEssaysDTOList;    public CanvasEssaysDTO(List<CanvasEssayDTO> canvasEssaysDTOList) {        this.canvasEssaysDTOList = canvasEssaysDTOList;    }    public List<CanvasEssayDTO> getCanvasEssaysDTOList() {        return canvasEssaysDTOList;    }}