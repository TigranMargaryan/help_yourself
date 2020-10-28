package com.help.yourself.core.data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "created", nullable = false)
    protected long created;

    @Column(name = "updated", nullable = false)
    protected long updated;

    public String getId() {
        return id;
    }

    public void setId(String id){this.id = id;}

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public long getCreated() {
        return created;
    }

    public void setCreated() {
        this.created = System.currentTimeMillis() / 1000;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated() {
        this.updated = System.currentTimeMillis() / 1000;
    }

    @PrePersist
    private void beforeSave() {
        setId();
        setCreated();
        setUpdated();
    }
}
