/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nasif
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT s FROM Author s"),
    @NamedQuery(name = "Author.findByAuthorID", query = "SELECT s FROM Author s WHERE s.authorID = :authorID"),
    @NamedQuery(name = "Author.findByFullName", query = "SELECT s FROM Author s WHERE s.fullname = :fullname"),
    @NamedQuery(name = "Author.findBooks", query = "SELECT c FROM Book c, BookAuthor e WHERE c.bookID = e.bookAuthorPK.bookID and e.bookAuthorPK.authorID = :authorID")})
   
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private String authorID;
    private String fullname;

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorID != null ? authorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorID == null && other.authorID != null) || (this.authorID != null && !this.authorID.equals(other.authorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Author[ authorID=" + authorID + " ]";
    }
    
}
