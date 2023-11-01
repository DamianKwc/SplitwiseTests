package com.splitwiseapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.User;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "events")
public class EventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Integer idEvent;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_owner")
    private UserEntity owner;

    @Column(name = "event_name", unique = true)
    private String eventName;

    @ManyToMany
    @JoinTable(name = "event_members",
    joinColumns = @JoinColumn(name = "id_event"),
    inverseJoinColumns = @JoinColumn(name = "id_user"))
    private Set<UserEntity> members = new HashSet<>();



}
