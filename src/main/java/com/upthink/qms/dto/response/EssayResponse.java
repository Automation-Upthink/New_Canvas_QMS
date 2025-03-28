package com.upthink.qms.dto.response;import gson.GsonDTO;import java.util.List;public class EssayResponse extends GsonDTO {    private final List<EssayDTO> essayDTOList;    private boolean success;    private String error;    public EssayResponse(List<EssayDTO> essayDTOList, boolean success, String error) {        this.essayDTOList = essayDTOList;        this.success = success;        this.error = error;    }    public List<EssayDTO> getEssayDTOList() {        return essayDTOList;    }    public boolean isSuccess() {        return success;    }    public String getError() {        return error;    }    public static class EssayDTO extends GsonDTO {        private final String clientName;        private final String essayId;        private final String checkedOutBy;        private final String status;        private final String fileLink;        private final long dueDate;        private final String downloadTime;        private final String getCheckedOutTime;        public EssayDTO(String clientName, String essayId, String status, String fileLink,                        long dueDate, String downloadTime) {            this.clientName = clientName;            this.essayId = essayId;            this.checkedOutBy = null;            this.status = status;            this.fileLink = fileLink;            this.dueDate = dueDate;            this.downloadTime = downloadTime;            this.getCheckedOutTime = null;        }        public EssayDTO(String clientName, String essayId, String checkedOutBy, String status, String fileLink,                       long dueDate, String downloadTime, String getCheckedOutTime) {            this.clientName = clientName;            this.essayId = essayId;            this.checkedOutBy = checkedOutBy;            this.status = status;            this.fileLink = fileLink;            this.dueDate = dueDate;            this.downloadTime = downloadTime;            this.getCheckedOutTime = getCheckedOutTime;        }        public String getClientName() {            return clientName;        }        public String getEssayId() {            return essayId;        }        public String getCheckedOutBy() {            return checkedOutBy;        }        public String getStatus() {            return status;        }        public String getFileLink() {            return fileLink;        }        public long getDueDate() {            return dueDate;        }        public String getDownloadTime() {            return downloadTime;        }        public String getGetCheckedOutTime() {            return getCheckedOutTime;        }    }}