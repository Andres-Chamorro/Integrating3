package model;

import java.util.Calendar;

public class Payment {
    private String idInvoice;
    private Calendar dateOperation;
    private double mountPayment;
    BibliographicResources resources;

    public Payment(String idInvoice, Calendar dateOperation, double mountPayment) {
        this.dateOperation = dateOperation;
        this.mountPayment = mountPayment;
    }

    public String getIdInvoice() {
        return this.idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Calendar getDateOperation() {
        return this.dateOperation;
    }

    public void setDateOperation(Calendar dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMountPayment() {
        return this.mountPayment;
    }

    public void setMountPayment(double mountPayment) {
        this.mountPayment = mountPayment;
    }

    public BibliographicResources getResources() {
        return this.resources;
    }

    public void setResources(BibliographicResources resources) {
        this.resources = resources;
    }

    public void setRecurso(BibliographicResources recurso) {
        this.resources = resources;
    }

