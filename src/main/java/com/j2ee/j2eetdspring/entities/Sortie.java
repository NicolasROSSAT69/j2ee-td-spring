package com.j2ee.j2eetdspring.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sortie")
public class Sortie {

    /*@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
    @Id
    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "duree")
    private Long duree;

    @Column(name = "complexite")
    @Enumerated
    private Complexite complexite;

    @Column(name = "lieu")
    private String lieu;

    /*@ManyToOne
    @JoinColumn(name = "user_id")
    private User encadrant;

    @OneToMany()
    @JoinColumn(name = "participant_id")
    private List<User> participant = new ArrayList<User>();*/


    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public Complexite getComplexite() {
        return complexite;
    }

    public void setComplexite(Complexite complexite) {
        this.complexite = complexite;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /*public User getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(User encadrant) {
        this.encadrant = encadrant;
    }*/
}
