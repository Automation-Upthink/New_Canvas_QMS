package com.upthink.qms.dto.request;import com.upthink.qms.model.Essay;import lombok.Getter;import lombok.Setter;@Getter@Setterpublic class UpdateEssayRequest extends AuthenticatedRequest {    private TokenValidation tokenValidationId;    private Essay data;    public UpdateEssayRequest(TokenValidation tokenValidationId, Essay data) {        super(tokenValidationId);        this.tokenValidationId = tokenValidationId;        this.data = data;    }}