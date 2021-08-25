package Model;

import java.util.Objects;

public class Utente {

    private int id;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String via;
    private String cap;
    private String paese;
    private String numero;
    private boolean isAdmin;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Utente utente = (Utente) o;
        return id == utente.id && isAdmin == utente.isAdmin &&
            Objects.equals(email, utente.email) &&
            Objects.equals(password, utente.password) &&
            Objects.equals(nome, utente.nome) &&
            Objects.equals(cognome, utente.cognome) &&
            Objects.equals(via, utente.via) && Objects.equals(cap, utente.cap) &&
            Objects.equals(paese, utente.paese) &&
            Objects.equals(numero, utente.numero);
    }

}
