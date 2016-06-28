package com.koshenya.koshenyablog.data.persistance;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.InputStream;
import java.sql.*;

/**
 * Created by Admin on 1/13/2016.
 */

@Entity
@Table(name="messages")
public class Message {

    @Column @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messages_id")
    @SequenceGenerator(name = "messages_id", sequenceName = "messages_id", allocationSize = 1)
    private int id;

    @Column(name="created")
    private Timestamp created;

    @Column(name="changed")
    private Timestamp changed;

    @Column(name="header")
    private String header;

    @Column(name="text")
    private String text;

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

    public Timestamp getChanged() {
        return changed;
    }

    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", created=" + created +
                ", changed=" + changed +
                ", text='" + text + '\'' +
                ", picture=" + picture +
                '}';
    }
}
