package entities;

import java.util.Date;

public class VacunaMascota {
    private Long idVacunaMascota;
    private String fechaRegistro;
    private Long idVacuna;


    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Long idVacuna) {
        this.idVacuna = idVacuna;
    }
}
