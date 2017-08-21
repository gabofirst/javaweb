/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author gabriel
 */
public class Estudiante {
    private int id_estudiante;
    private String ci;
    private String ru;
    private String nombre_completo;
    /**
     * @return the id_estudiante
     */
    public int getId_estudiante() {
        return id_estudiante;
    }

    /**
     * @param id_estudiante the id_estudiante to set
     */
    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    /**
     * @return the ci
     */
    public String getCi() {
        return ci;
    }

    /**
     * @param ci the ci to set
     */
    public void setCi(String ci) {
        this.ci = ci;
    }

    /**
     * @return the ru
     */
    public String getRu() {
        return ru;
    }

    /**
     * @param ru the ru to set
     */
    public void setRu(String ru) {
        this.ru = ru;
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
    
}
