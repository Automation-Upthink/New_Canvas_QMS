package com.upthink.Canavas_QMS.dto.request;import com.upthink.Canavas_QMS.dto.request.TokenValidation;import lombok.Getter;import lombok.Setter;import lombok.NoArgsConstructor;import lombok.AllArgsConstructor;@Getter@Setterpublic class GetCourseByIdRequest extends AuthenticatedRequest {    private TokenValidation tokenValidationId;    public GetCourseByIdRequest(TokenValidation tokenValidationId) {        super(tokenValidationId);        this.tokenValidationId = tokenValidationId;    }}