/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.bookEJB;
import entity.Author;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author nasif
 */
@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean {

    @EJB
    private bookEJB bookEJB;

    /**
     * Creates a new instance of IndexBean
     */
    public MainPageBean() {
    }

    public List<Author> getAuthorList() {
        return bookEJB.findAllAuthors();
    }
}
