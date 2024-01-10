/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.bookEJB;
import entity.Author;
import entity.Book;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author nasif
 */
@Named(value = "showAuthorBean")
@RequestScoped
public class ShowAuthorBean {

    @EJB
    private bookEJB bookEJB;
    private Author author;

    /**
     * Creates a new instance of ShowAuthorBean
     */
    public ShowAuthorBean() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String showAuthor(Author author) {
        this.author = author;
        return "ShowAuthor.xhtml";
    }

    public String backToAuthor() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        String authorID = params.get("authorID");
        author = bookEJB.getAuthor(authorID);
        return "ShowAuthor.xhtml";
    }

    public String showBooks() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        String authorID = params.get("authorID");
        author = bookEJB.getAuthor(authorID);
        return "Books.xhtml";
    }

    public List<Book> getBookList() {
        if (author != null) {
            return bookEJB.getBooksForAuthor(author.getAuthorID());
        } else {
            return null;
        }
    }
}
