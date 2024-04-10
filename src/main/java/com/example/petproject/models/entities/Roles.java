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
    List<Users> users;
    private RoleEnum roleName;

    protected Roles() {
    }

    public Roles(RoleEnum roleName) {
        this.roleName = roleName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Enumerated(EnumType.STRING)
    public RoleEnum getRoleName() {
        return roleName;
    }
    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }
}
