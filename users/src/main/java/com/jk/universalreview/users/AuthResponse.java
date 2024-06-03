package com.jk.universalreview.users;

import java.util.Collection;
import java.util.Objects;

public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private Long expireAt;
    private Collection<String> authorities;

    //generate getter and setters. Generate NoArg Constructor, generat all Args constructor, generate equals and hashcode, generate toString

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }

    public AuthResponse(String userId, String accessToken, String refreshToken, Long expireAt, Collection<String> authorities) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireAt = expireAt;
        this.authorities = authorities;
    }

    public AuthResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthResponse that = (AuthResponse) o;
        return userId.equals(that.userId) && accessToken.equals(that.accessToken) && refreshToken.equals(that.refreshToken) && expireAt.equals(that.expireAt) && authorities.equals(that.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, accessToken, refreshToken, expireAt, authorities);
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "userId='" + userId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expireAt=" + expireAt +
                ", authorities=" + authorities +
                '}';
    }
}
