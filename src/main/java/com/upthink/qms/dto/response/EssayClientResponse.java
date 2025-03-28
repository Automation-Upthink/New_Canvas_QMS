package com.upthink.qms.dto.response;import gson.GsonDTO;import java.util.List;public class EssayClientResponse extends GsonDTO {    private final List<EssayClientDTO> essayClientDTOList;    public EssayClientResponse(List<EssayClientDTO> essayClientDTOList) {        this.essayClientDTOList = essayClientDTOList;    }    public class EssayClientDTO extends GsonDTO{        private final int id;        private final String name;        public EssayClientDTO(int id, String name) {            this.id = id;            this.name = name;        }        public int getId() {            return id;        }        public String getName() {            return name;        }    }}