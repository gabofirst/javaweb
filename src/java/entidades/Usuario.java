/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Gabriel Casas
 */
public class Usuario {
    private int id_usuario;
    private String nombre_completo;
    private String usuario;
    private String clave;

    public Usuario(){}
    public Usuario(String usuario, String clave) {
        this.usuario=usuario;
        this.clave=clave;
    }
    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    /**
     * @return the nombre_completo
     */
    public String getNombre_completo() {
        return nombre_completo;
    }

    /**
     * @param nombre_completo the nombre_completo to set
     */
    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }


    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
}