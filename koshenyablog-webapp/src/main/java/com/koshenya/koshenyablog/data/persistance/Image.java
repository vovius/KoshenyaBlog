package com.koshenya.koshenyablog.data.persistance;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "images", schema = "ROOT")
public class Image {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_id")
    @SequenceGenerator(name = "images_id", sequenceName = "images_id", allocationSize = 1)
    private int id;

    @Column(name="created")
    private Timestamp created;

    @Column(name="description")
    private String description;

    @Column(name="picture")
    @Lob
    private byte[] picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
