package entities;

import java.util.Date;

public class RegistroCuidado {
    private Long idRegistroCuidado;
    private Date fechaRegistro;
    private Date fechaRealizado;
    private boolean status;
    private Long idCuidado;

    public Long getIdRegistroCuidado() {
        return idRegistroCuidado;
    }
    public void setIdRegistroCuidado(Long idRegistroCuidado) {
        this.idRegistroCuidado = idRegistroCuidado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }
    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getIdCuidado() {
        return idCuidado;
    }
    public void setIdCuidado(Long idCuidado) {
        this.idCuidado = idCuidado;
    }

    @Override
    public String toString(){
        return "RegistroCuidado{" +
                "idRegistroCuidado=" + idRegistroCuidado +
                "idCuidado=" + idCuidado+
                "FechadeRegistro=" + fechaRegistro +
                "FechadeRealizacion=" + fechaRealizado +
                "Estado=" + status+
                '}';
    }

}
