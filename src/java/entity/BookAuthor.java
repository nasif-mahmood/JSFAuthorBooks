/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nasif
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "BookAuthor.findAll", query = "SELECT e FROM BookAuthor e"),
    @NamedQuery(name = "BookAuthor.findByAuthorID", query = "SELECT e FROM BookAuthor e WHERE e.bookAuthorPK.authorID = :authorID"),
    @NamedQuery(name = "BookAuthor.findByBookID", query = "SELECT e FROM BookAuthor e WHERE e.bookAuthorPK.bookID = :bookID")})
public class BookAuthor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BookAuthorPK bookAuthorPK;

    public BookAuthorPK getBookAuthorPK() {
        return bookAuthorPK;
    }

    public void setBookAuthorPK(BookAuthorPK bookAuthorPK) {
        this.bookAuthorPK = bookAuthorPK;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookAuthorPK != null ? bookAuthorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookAuthor)) {
            return false;
        }
        BookAuthor other = (BookAuthor) object;
        if ((this.bookAuthorPK == null && other.bookAuthorPK != null) || (this.bookAuthorPK != null && !this.bookAuthorPK.equals(other.bookAuthorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BookAuthor[ bookAuthorPK=" + bookAuthorPK + " ]";
    }
    
}
