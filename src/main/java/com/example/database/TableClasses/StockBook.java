package com.example.database.TableClasses;

public class StockBook {
    private int id;
    private int receipt_amount;

    private String miti;
    private String particulars;
    private String receipt_quantity;
    private String receipt_rate;
    private String issued_quantity;
    private String balance_quantity;
    private String remarks;
    private String article_name;

    public StockBook(){
        this(0, "2022-01-01", "", "", "", "", "", "", "");
    }

    public StockBook(int receipt_amount, String miti, String particulars, String receipt_quantity, String receipt_rate, String issued_quantity, String balance_quantity, String remarks, String article_name) {
        this.id = -1;
        this.miti = miti;
        this.particulars = particulars;
        this.receipt_quantity = receipt_quantity;
        this.receipt_rate = receipt_rate;
        this.receipt_amount = receipt_amount;
        this.issued_quantity = issued_quantity;
        this.balance_quantity = balance_quantity;
        this.remarks = remarks;
        this.article_name = article_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceipt_amount() {
        return receipt_amount;
    }

    public void setReceipt_amount(int receipt_amount) {
        this.receipt_amount = receipt_amount;
    }

    public String getMiti() {
        return miti;
    }

    public void setMiti(String miti) {
        this.miti = miti;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getReceipt_quantity() {
        return receipt_quantity;
    }

    public void setReceipt_quantity(String receipt_quantity) {
        this.receipt_quantity = receipt_quantity;
    }

    public String getReceipt_rate() {
        return receipt_rate;
    }

    public void setReceipt_rate(String receipt_rate) {
        this.receipt_rate = receipt_rate;
    }

    public String getIssued_quantity() {
        return issued_quantity;
    }

    public void setIssued_quantity(String issued_quantity) {
        this.issued_quantity = issued_quantity;
    }

    public String getBalance_quantity() {
        return balance_quantity;
    }

    public void setBalance_quantity(String balance_quantity) {
        this.balance_quantity = balance_quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }
}
