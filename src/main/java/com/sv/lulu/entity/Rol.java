package com.sv.lulu.entity;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column
    @Getter
    private String rol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rol rol = (Rol) o;
        return id_rol != null && Objects.equals(id_rol, rol.id_rol);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
