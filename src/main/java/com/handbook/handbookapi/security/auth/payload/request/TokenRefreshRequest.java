package com.handbook.handbookapi.security.auth.payload.request;

import javax.validation.constraints.NotBlank;


public class TokenRefreshRequest {

    @NotBlank
    private String refreshToken;

    public @NotBlank String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(@NotBlank String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
