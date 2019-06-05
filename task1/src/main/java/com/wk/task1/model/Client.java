package com.wk.task1.model;

/**
 * @author Denis Khalaev
 */
public class Client {

    private Long idClient;
    private String name;
    private Long tariffId;
    private Double balance;

    public Client() {
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTariffId() {
        return tariffId;
    }

    public void setTariffId(Long tariffId) {
        this.tariffId = tariffId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client:" +
                "\nidClient= " + idClient +
                "\nname='" + name + '\'' +
                "\ntariffId=" + tariffId +
                "\nbalance=" + balance;
    }
}
