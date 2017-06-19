package com.balance.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "escalares_history")
public class EscalaresHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "escalares_history_id")
    private Integer id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "fecha_evento")
    private Date fecha_evento;

    @Column(name = "fecha_registro")
    private Date fecha_registro;

    public EscalaresHistory() {

    }

    public EscalaresHistory(Integer cantidad, String tipo, Integer user_id, Date fecha_evento, Date fecha_registro) {
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.user_id = user_id;
        this.fecha_evento = fecha_evento;
        this.fecha_registro = fecha_registro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(Date fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
