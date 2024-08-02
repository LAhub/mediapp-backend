package com.mitocode.model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "signos")
public class Signos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSignos;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_signos_paciente"))
    private Patient paciente;

    @Column(name = "fecha", nullable = true)
    private LocalDateTime fecha;

    @Column(name = "temperatura", nullable = true)
    private Double temperatura;

    @Column(name = "pulso", nullable = true)
    private Integer pulso;

    @Column(name = "ritmo_resp", nullable = true)
    private Integer ritmoRespiratorio;

    public Integer getIdSignos() {
        return idSignos;
    }

    public void setIdSignos(Integer idSignos) {
        this.idSignos = idSignos;
    }

    public Patient getPaciente() {
        return paciente;
    }

    public void setPaciente(Patient paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getPulso() {
        return pulso;
    }

    public void setPulso(Integer pulso) {
        this.pulso = pulso;
    }

    public Integer getRitmoRespiratorio() {
        return ritmoRespiratorio;
    }

    public void setRitmoRespiratorio(Integer ritmoRespiratorio) {
        this.ritmoRespiratorio = ritmoRespiratorio;
    }

}
