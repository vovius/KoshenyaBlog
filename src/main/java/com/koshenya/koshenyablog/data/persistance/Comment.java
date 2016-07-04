package com.koshenya.koshenyablog.data.persistance;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comments")
public class Comment implements Comparable<Comment> {
    @Column @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_id")
    @SequenceGenerator(name = "comments_id", sequenceName = "comments_id", allocationSize = 1)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_message", nullable = false)
    private Message message;

    @Column(name="created")
    private Timestamp created;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private Comment parentComment;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentComment")
    private Set<Comment> childComments = new HashSet<Comment>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Set<Comment> getChildComments() {
        return childComments;
    }

    public void setChildComments(Set<Comment> childComments) {
        this.childComments = childComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (!message.equals(comment.message)) return false;
        if (!created.equals(comment.created)) return false;
        if (name != null ? !name.equals(comment.name) : comment.name != null) return false;
        if (email != null ? !email.equals(comment.email) : comment.email != null) return false;
        return text != null ? text.equals(comment.text) : comment.text == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + message.hashCode();
        result = 31 * result + created.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Comment o) {

        if (o.getParentComment() == null && this.getParentComment() != null)
            return -1;
        if (o.getParentComment() != null && this.getParentComment() == null)
            return 1;

        // it's possible here to verify parent-child by ==, not by equals
        if (this == o.getParentComment() )
            return 1;
        else if (this.getParentComment() != null && this.getParentComment() == o)
            return -1;
        else if (o == this)
            return 0;

        if (!created.equals(o.created))
            return (-1)*created.compareTo(o.created);
        if (id != o.id)
            return new Integer(id).compareTo(o.id);


        return 0;
    }
}
