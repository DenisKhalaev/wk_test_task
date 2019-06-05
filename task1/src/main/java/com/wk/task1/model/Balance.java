package com.wk.task1.model;

import java.util.Date;

/**
 * @author Denis Khalaev
 */
public class Balance {

    private Long idBalance;
    private Long clientId;
    private Date date;
    private Double payment;
    private Double refill;

    public Balance() {
    }

    public Long getIdBalance() {
        return idBalance;
    }

    public void setIdBalance(Long idBalance) {
        this.idBalance = idBalance;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Double getRefill() {
        return refill;
    }

    public void setRefill(Double refill) {
        this.refill = refill;
    }

    @Override
    public String toString() {
        return "Balance:" +
                "\nidBalance=" + idBalance +
                "\nclientId=" + clientId +
                "\ndate=" + date +
                "\npayment=" + payment +
                "\nrefill=" + refill;
    }
}

