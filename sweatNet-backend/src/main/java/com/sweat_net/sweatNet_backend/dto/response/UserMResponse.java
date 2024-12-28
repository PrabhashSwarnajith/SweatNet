package com.sweat_net.sweatNet_backend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserMResponse {
    private String UserId;
    private String massage;
}
