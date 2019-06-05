package com.wk.task1.model;

/**
 * @author Denis Khalaev
 */
public class Tariff {

    private Long idTariff;
    private String nameTariff;
    private Double charge;

    public Tariff() {
    }

    public Long getIdTariff() {
        return idTariff;
    }

    public void setIdTariff(Long idTariff) {
        this.idTariff = idTariff;
    }

    public String getNameTariff() {
        return nameTariff;
    }

    public void setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "Tariff:" +
                "\nidTariff=" + idTariff +
                "\nnameTariff='" + nameTariff + '\'' +
                "\ncharge=" + charge;
    }
}
