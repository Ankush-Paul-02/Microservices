package com.devmare.user.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ABOUT")
    private String about;

    @Transient  //? We don't want to save it in DB so JPA ignores it
    private List<Rating> ratings = new ArrayList<>();
}
