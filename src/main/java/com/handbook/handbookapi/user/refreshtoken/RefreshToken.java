package com.handbook.handbookapi.user.refreshtoken;

import com.handbook.handbookapi.common.BaseEntity;
import com.handbook.handbookapi.user.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "refresh_tokens")
@SequenceGenerator(name = "seq_refresh_tokens", sequenceName = "seq_refresh_tokens")
public class RefreshToken implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_refresh_tokens")
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;

    public RefreshToken() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }
}
