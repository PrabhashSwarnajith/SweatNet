package com.sweat_net.sweatNet_backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMResponse {
    private String UserId;
    private String message;
}
