package com.base.main.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "sinhvien")
@Data
public class Sinhvien implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @PrimaryKeyJoinColumn(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lop", nullable = false)
    private String lop;

    @Column(name = "tuoi", nullable = false)
    private Integer tuoi;

    @OneToOne(mappedBy = "sinhvien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ThongTinSinhVien thongTinSinhVien;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "sinhvien_role",
            joinColumns = @JoinColumn(name = "sinhvien_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
        role.getSinhviens().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getSinhviens().remove(this);
    }

    @OneToMany(mappedBy = "sinhvien", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Diem> diems = new HashSet<>();


}
