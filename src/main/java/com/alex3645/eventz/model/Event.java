package com.alex3645.eventz.model;

import com.alex3645.eventz.model.enums.SecureType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
@Data
public class Event extends BaseEntity {
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private List<User> users;

    @ManyToMany()
    @JoinTable(name = "admins_events",
            joinColumns = {@JoinColumn(name = "event_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<User> admins;

    @Column(name = "info")
    private String info;

    @Enumerated(EnumType.STRING)
    @Column(name = "secure")
    private SecureType secure;

    @Column(name = "open")
    private boolean open;
}
