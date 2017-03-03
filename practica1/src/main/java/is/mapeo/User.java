/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Cygnus
 */
@Entity
@Table(name="user")
public class User {
    @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="iduser")
    private int id;
    
    @Column(name="correo")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @OneToOne
    @JoinColumn(name="persona_id")
    @MapsId
    private Persona persona;

    public User() {}
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}