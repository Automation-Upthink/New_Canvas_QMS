package com.upthink.Canavas_QMS.dto.request;import com.upthink.Canavas_QMS.model.Assignment;public class CreateAssignmentRequest extends AuthenticatedRequest {    public CreateAssignmentRequest(TokenValidation tokenValidationId, Assignment data) {        super(tokenValidationId);    }}