package com.upthink.Canavas_QMS.dto.request;import com.upthink.Canavas_QMS.model.EssayDetails;import com.upthink.Canavas_QMS.dto.request.TokenValidation;import lombok.Getter;import lombok.Setter;import lombok.NoArgsConstructor;import lombok.AllArgsConstructor;@Getter@Setterpublic class CreateEssayDetailsRequest extends AuthenticatedRequest {    private TokenValidation tokenValidationId;    private EssayDetails data;    public CreateEssayDetailsRequest(TokenValidation tokenValidationId, EssayDetails data) {        super(tokenValidationId);        this.tokenValidationId = tokenValidationId;        this.data = data;    }}