package com.upthink.qms.dto.request;import com.upthink.qms.model.Person;import lombok.Getter;import lombok.Setter;@Getter@Setterpublic class UpdatePersonRequest extends AuthenticatedRequest {    private TokenValidation tokenValidationId;    private Person data;    public UpdatePersonRequest(TokenValidation tokenValidationId, Person data) {        super(tokenValidationId);        this.tokenValidationId = tokenValidationId;        this.data = data;    }}