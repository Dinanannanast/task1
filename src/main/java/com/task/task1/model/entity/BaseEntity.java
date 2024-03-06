package com.task.task1.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity<PK extends Serializable> implements Persistable<PK> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updated;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    @Transient
    @Override
    public boolean isNew() {
        return false;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null) {
            return false;
        }

        if (!getClass().equals(ProxyUtils.getUserClass(another))) return false;

        BaseEntity<?> castedAnother = ((BaseEntity<?>) another);

        return Objects.equals(id, castedAnother.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), this.getId());
    }
}
