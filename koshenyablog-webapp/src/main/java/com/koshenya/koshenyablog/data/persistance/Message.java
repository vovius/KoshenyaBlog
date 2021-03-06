package com.koshenya.koshenyablog.data.persistance;

import com.koshenya.koshenyablog.util.BackendHtmlGenerator;
import com.koshenya.koshenyablog.util.BlogUtils;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.OrderBy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.InputStream;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 1/13/2016.
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="messages", schema = "ROOT")
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

    @Column(name="visible")
    private boolean visible;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "message")
    @Where(clause = "id_parent is null")
    @OrderBy(clause = "created")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Comment> comments;

    public Comment getCommentById(int commentId) {
        Comment comment = commentsTreeWalkForId(comments, commentId);
        return comment;
    }

    private Comment commentsTreeWalkForId(Set<Comment> comments, int id) {
        Comment result = null;
        for (Comment comment : comments) {

            if (result != null)
                break;

            if (comment.getId() == id) {
                result = comment;
                break;
            }

            if (!comment.getChildComments().isEmpty())
                result = commentsTreeWalkForId(comment.getChildComments(), id);
        }

        return result;
    }

    public String getCommentsTreeHtml() {
        return BackendHtmlGenerator.getHtmlForCommentsSection(comments);
    }

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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", created=" + created +
                ", changed=" + changed +
                ", header='" + header + '\'' +
                ", text='" + text + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", visible=" + visible +
                '}';
    }

    public String getProcessedText() {
        return BlogUtils.processMessageText(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (visible != message.visible) return false;
        if (!created.equals(message.created)) return false;
        if (changed != null ? !changed.equals(message.changed) : message.changed != null) return false;
        if (header != null ? !header.equals(message.header) : message.header != null) return false;
        return text != null ? text.equals(message.text) : message.text == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + created.hashCode();
        result = 31 * result + (changed != null ? changed.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (visible ? 1 : 0);
        return result;
    }
}
