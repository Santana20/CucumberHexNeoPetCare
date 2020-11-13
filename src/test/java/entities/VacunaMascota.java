package entities;

import java.util.Date;

public class VacunaMascota {
    private Long idVacunaMascota;

    private Date fechaRegistro;
    private Date fechaVacunaRealizada;
    private boolean status;
    private Long idVacuna;
    private Long idMascota;

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaVacunaRealizada() {
        return fechaVacunaRealizada;
    }

    public void setFechaVacunaRealizada(Date fechaVacunaRealizada) {
        this.fechaVacunaRealizada = fechaVacunaRealizada;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Long idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }
}
