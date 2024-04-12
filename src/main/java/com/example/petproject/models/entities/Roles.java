package com.example.petproject.models.entities;

import com.example.petproject.models.enums.RoleEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "created", column = @Column(insertable = false, updatable = false)),
        @AttributeOverride(name = "modified", column = @Column(insertable = false, updatable = false))
})

public class Roles extends BaseEntity {
    List<User> user;
    private RoleEnum roleName;

    protected Roles() {
    }

    public Roles(RoleEnum roleName) {
        this.roleName = roleName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<User> getUser() {
        return user;
    }
    public void setUser(List<User> user) {
        this.user = user;
    }

    @Enumerated(EnumType.STRING)
    public RoleEnum getRoleName() {
        return roleName;
    }
    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }
}
