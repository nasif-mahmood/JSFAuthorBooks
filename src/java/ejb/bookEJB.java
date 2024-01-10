/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Author;
import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nasif
 */
@Stateless
public class bookEJB {

    @PersistenceContext(unitName = "JSFAuthorBooksPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Author> findAllAuthors() {
        return em.createNamedQuery("Author.findAll", Author.class).getResultList();
    }

    public Author getAuthor(String authorID) {
        return em.createNamedQuery("Author.findByAuthorID", Author.class)
                .setParameter("authorID", authorID)
                .getSingleResult();
    }

    public List<Book> getBooksForAuthor(String authorID) {
        return em.createNamedQuery("Author.findBooks", Book.class)
                .setParameter("authorID", authorID)
                .getResultList();
    }

}
