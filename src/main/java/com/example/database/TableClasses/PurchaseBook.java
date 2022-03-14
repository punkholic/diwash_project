package com.example.database.TableClasses;

public class PurchaseBook {
    private String date;
    private int id;
    private int pragyapan_patra_number;
    private int aapurtikarta_esthati_number;
    private String aapurtikarta_nam;
    private String kharid_pauthari_bastu;
    private String kharid_bastu_parimad;
    private String jamma_kharid;
    private String kar_chut_bastu;
    private String kar_yogya_kharid_mulya;
    private String kar_yogya_kharid_kar_ru;
    private String kar_yogya_pauthari_mulya;
    private String kar_yogya_pauthari_kar_ru;
    private String pujigat_kar_yogya_kharid_mulya;
    private String pujigat_kar_yogya_kharid_kar_ru;

    private String jamma_kharid_1;
    private String jamma_kharid_2;
    private String kar_chut_bastu_1;
    private String kar_chut_bastu_2;

    private String kar_yogya_kharid_mulya_1;
    private String kar_yogya_kharid_mulya_2;
    private String kar_yogya_kharid_kar_ru_1;
    private String kar_yogya_kharid_kar_ru_2;
    private String kar_yogya_pauthari_mulya_1;
    private String kar_yogya_pauthari_mulya_2;
    private String kar_yogya_pauthari_kar_ru_1;
    private String kar_yogya_pauthari_kar_ru_2;
    private String pujigat_kar_yogya_kharid_mulya_1;
    private String pujigat_kar_yogya_kharid_mulya_2;
    private String pujigat_kar_yogya_kharid_kar_ru_1;
    private String pujigat_kar_yogya_kharid_kar_ru_2;

    public PurchaseBook(){
        this("2022-01-01", 0, 0, "", "", "", "", "", "", "", "", "", "", "");
    }

    public PurchaseBook(String date, int pragyapan_patra_number, int aapurtikarta_esthati_number, String aapurtikarta_nam, String kharid_pauthari_bastu, String kharid_bastu_parimad, String jamma_kharid, String kar_chut_bastu, String kar_yogya_kharid_mulya, String kar_yogya_kharid_kar_ru, String kar_yogya_pauthari_mulya, String kar_yogya_pauthari_kar_ru, String pujigat_kar_yogya_kharid_mulya, String pujigat_kar_yogya_kharid_kar_ru) {
        this.date = date;
        this.id = -1;
        this.pragyapan_patra_number = pragyapan_patra_number;
        this.aapurtikarta_nam = aapurtikarta_nam;
        this.aapurtikarta_esthati_number = aapurtikarta_esthati_number;
        this.kharid_pauthari_bastu = kharid_pauthari_bastu;
        this.kharid_bastu_parimad = kharid_bastu_parimad;
        String[] splitedValue;

        this.jamma_kharid = jamma_kharid;
        splitedValue = split(this.jamma_kharid);
        this.jamma_kharid_1 = splitedValue[0]; this.jamma_kharid_2 = splitedValue[1];

        this.kar_chut_bastu = kar_chut_bastu;
        splitedValue = split(this.kar_chut_bastu);
        this.kar_chut_bastu_1 = splitedValue[0]; this.kar_chut_bastu_2 = splitedValue[1];


        this.kar_yogya_kharid_mulya = kar_yogya_kharid_mulya;
        splitedValue = split(this.kar_yogya_kharid_mulya);
        this.kar_yogya_kharid_mulya_1 = splitedValue[0]; this.kar_yogya_kharid_mulya_2 = splitedValue[1];

        this.kar_yogya_kharid_kar_ru = kar_yogya_kharid_kar_ru;
        splitedValue = split(this.kar_yogya_kharid_kar_ru);
        this.kar_yogya_kharid_kar_ru_1 = splitedValue[0]; this.kar_yogya_kharid_kar_ru_2 = splitedValue[1];

        this.kar_yogya_pauthari_mulya = kar_yogya_pauthari_mulya;
        splitedValue = split(this.kar_yogya_pauthari_mulya);
        this.kar_yogya_pauthari_mulya_1 = splitedValue[0]; this.kar_yogya_pauthari_mulya_2 = splitedValue[1];

        this.kar_yogya_pauthari_kar_ru = kar_yogya_pauthari_kar_ru;
        splitedValue = split(this.kar_yogya_pauthari_kar_ru);
        this.kar_yogya_pauthari_kar_ru_1 = splitedValue[0]; this.kar_yogya_pauthari_kar_ru_2 = splitedValue[1];

        this.pujigat_kar_yogya_kharid_mulya = pujigat_kar_yogya_kharid_mulya;
        splitedValue = split(this.pujigat_kar_yogya_kharid_mulya);
        this.pujigat_kar_yogya_kharid_mulya_1 = splitedValue[0]; this.pujigat_kar_yogya_kharid_mulya_2 = splitedValue[1];

        this.pujigat_kar_yogya_kharid_kar_ru = pujigat_kar_yogya_kharid_kar_ru;
        splitedValue = split(this.pujigat_kar_yogya_kharid_kar_ru);
        this.pujigat_kar_yogya_kharid_kar_ru_1 = splitedValue[0]; this.pujigat_kar_yogya_kharid_kar_ru_2 = splitedValue[1];

    }

    public String[] split(String toSplit){
        String[] toReturn = toSplit.split("\\|");
        if (toReturn.length != 2){
            return new String[]{toSplit, ""};
        }
        return toReturn;
    }

    public String getJamma_kharid_1() {
        return jamma_kharid_1;
    }

    public void setJamma_kharid_1(String jamma_kharid_1) {
        this.jamma_kharid_1 = jamma_kharid_1;
    }

    public String getJamma_kharid_2() {
        return jamma_kharid_2;
    }

    public void setJamma_kharid_2(String jamma_kharid_2) {
        this.jamma_kharid_2 = jamma_kharid_2;
    }

    public String getKar_chut_bastu_1() {
        return kar_chut_bastu_1;
    }

    public void setKar_chut_bastu_1(String kar_chut_bastu_1) {
        this.kar_chut_bastu_1 = kar_chut_bastu_1;
    }

    public String getKar_chut_bastu_2() {
        return kar_chut_bastu_2;
    }

    public void setKar_chut_bastu_2(String kar_chut_bastu_2) {
        this.kar_chut_bastu_2 = kar_chut_bastu_2;
    }

    public String getKar_yogya_kharid_mulya_1() {
        return kar_yogya_kharid_mulya_1;
    }

    public void setKar_yogya_kharid_mulya_1(String kar_yogya_kharid_mulya_1) {
        this.kar_yogya_kharid_mulya_1 = kar_yogya_kharid_mulya_1;
    }

    public String getKar_yogya_kharid_mulya_2() {
        return kar_yogya_kharid_mulya_2;
    }

    public void setKar_yogya_kharid_mulya_2(String kar_yogya_kharid_mulya_2) {
        this.kar_yogya_kharid_mulya_2 = kar_yogya_kharid_mulya_2;
    }

    public String getKar_yogya_kharid_kar_ru_1() {
        return kar_yogya_kharid_kar_ru_1;
    }

    public void setKar_yogya_kharid_kar_ru_1(String kar_yogya_kharid_kar_ru_1) {
        this.kar_yogya_kharid_kar_ru_1 = kar_yogya_kharid_kar_ru_1;
    }

    public String getKar_yogya_kharid_kar_ru_2() {
        return kar_yogya_kharid_kar_ru_2;
    }

    public void setKar_yogya_kharid_kar_ru_2(String kar_yogya_kharid_kar_ru_2) {
        this.kar_yogya_kharid_kar_ru_2 = kar_yogya_kharid_kar_ru_2;
    }

    public String getKar_yogya_pauthari_mulya_1() {
        return kar_yogya_pauthari_mulya_1;
    }

    public void setKar_yogya_pauthari_mulya_1(String kar_yogya_pauthari_mulya_1) {
        this.kar_yogya_pauthari_mulya_1 = kar_yogya_pauthari_mulya_1;
    }

    public String getKar_yogya_pauthari_mulya_2() {
        return kar_yogya_pauthari_mulya_2;
    }

    public void setKar_yogya_pauthari_mulya_2(String kar_yogya_pauthari_mulya_2) {
        this.kar_yogya_pauthari_mulya_2 = kar_yogya_pauthari_mulya_2;
    }

    public String getKar_yogya_pauthari_kar_ru_1() {
        return kar_yogya_pauthari_kar_ru_1;
    }

    public void setKar_yogya_pauthari_kar_ru_1(String kar_yogya_pauthari_kar_ru_1) {
        this.kar_yogya_pauthari_kar_ru_1 = kar_yogya_pauthari_kar_ru_1;
    }

    public String getKar_yogya_pauthari_kar_ru_2() {
        return kar_yogya_pauthari_kar_ru_2;
    }

    public void setKar_yogya_pauthari_kar_ru_2(String kar_yogya_pauthari_kar_ru_2) {
        this.kar_yogya_pauthari_kar_ru_2 = kar_yogya_pauthari_kar_ru_2;
    }

    public String getPujigat_kar_yogya_kharid_mulya_1() {
        return pujigat_kar_yogya_kharid_mulya_1;
    }

    public void setPujigat_kar_yogya_kharid_mulya_1(String pujigat_kar_yogya_kharid_mulya_1) {
        this.pujigat_kar_yogya_kharid_mulya_1 = pujigat_kar_yogya_kharid_mulya_1;
    }

    public String getPujigat_kar_yogya_kharid_mulya_2() {
        return pujigat_kar_yogya_kharid_mulya_2;
    }

    public void setPujigat_kar_yogya_kharid_mulya_2(String pujigat_kar_yogya_kharid_mulya_2) {
        this.pujigat_kar_yogya_kharid_mulya_2 = pujigat_kar_yogya_kharid_mulya_2;
    }

    public String getPujigat_kar_yogya_kharid_kar_ru_1() {
        return pujigat_kar_yogya_kharid_kar_ru_1;
    }

    public void setPujigat_kar_yogya_kharid_kar_ru_1(String pujigat_kar_yogya_kharid_kar_ru_1) {
        this.pujigat_kar_yogya_kharid_kar_ru_1 = pujigat_kar_yogya_kharid_kar_ru_1;
    }

    public String getPujigat_kar_yogya_kharid_kar_ru_2() {
        return pujigat_kar_yogya_kharid_kar_ru_2;
    }

    public void setPujigat_kar_yogya_kharid_kar_ru_2(String pujigat_kar_yogya_kharid_kar_ru_2) {
        this.pujigat_kar_yogya_kharid_kar_ru_2 = pujigat_kar_yogya_kharid_kar_ru_2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPragyapan_patra_number() {
        return pragyapan_patra_number;
    }

    public void setPragyapan_patra_number(int pragyapan_patra_number) {
        this.pragyapan_patra_number = pragyapan_patra_number;
    }

    public int getAapurtikarta_esthati_number() {
        return aapurtikarta_esthati_number;
    }

    public void setAapurtikarta_esthati_number(int aapurtikarta_esthati_number) {
        this.aapurtikarta_esthati_number = aapurtikarta_esthati_number;
    }

    public String getAapurtikarta_nam() {
        return aapurtikarta_nam;
    }

    public void setAapurtikarta_nam(String aapurtikarta_nam) {
        this.aapurtikarta_nam = aapurtikarta_nam;
    }

    public String getKharid_pauthari_bastu() {
        return kharid_pauthari_bastu;
    }

    public void setKharid_pauthari_bastu(String kharid_pauthari_bastu) {
        this.kharid_pauthari_bastu = kharid_pauthari_bastu;
    }

    public String getKharid_bastu_parimad() {
        return kharid_bastu_parimad;
    }

    public void setKharid_bastu_parimad(String kharid_bastu_parimad) {
        this.kharid_bastu_parimad = kharid_bastu_parimad;
    }

    public String getJamma_kharid() {
        return jamma_kharid;
    }

    public void setJamma_kharid(String jamma_kharid) {
        this.jamma_kharid = jamma_kharid;
    }

    public String getKar_chut_bastu() {
        return kar_chut_bastu;
    }

    public void setKar_chut_bastu(String kar_chut_bastu) {
        this.kar_chut_bastu = kar_chut_bastu;
    }

    public String getKar_yogya_kharid_mulya() {
        return kar_yogya_kharid_mulya;
    }

    public void setKar_yogya_kharid_mulya(String kar_yogya_kharid_mulya) {
        this.kar_yogya_kharid_mulya = kar_yogya_kharid_mulya;
    }

    public String getKar_yogya_kharid_kar_ru() {
        return kar_yogya_kharid_kar_ru;
    }

    public void setKar_yogya_kharid_kar_ru(String kar_yogya_kharid_kar_ru) {
        this.kar_yogya_kharid_kar_ru = kar_yogya_kharid_kar_ru;
    }

    public String getKar_yogya_pauthari_mulya() {
        return kar_yogya_pauthari_mulya;
    }

    public void setKar_yogya_pauthari_mulya(String kar_yogya_pauthari_mulya) {
        this.kar_yogya_pauthari_mulya = kar_yogya_pauthari_mulya;
    }

    public String getKar_yogya_pauthari_kar_ru() {
        return kar_yogya_pauthari_kar_ru;
    }

    public void setKar_yogya_pauthari_kar_ru(String kar_yogya_pauthari_kar_ru) {
        this.kar_yogya_pauthari_kar_ru = kar_yogya_pauthari_kar_ru;
    }

    public String getPujigat_kar_yogya_kharid_mulya() {
        return pujigat_kar_yogya_kharid_mulya;
    }

    public void setPujigat_kar_yogya_kharid_mulya(String pujigat_kar_yogya_kharid_mulya) {
        this.pujigat_kar_yogya_kharid_mulya = pujigat_kar_yogya_kharid_mulya;
    }

    public String getPujigat_kar_yogya_kharid_kar_ru() {
        return pujigat_kar_yogya_kharid_kar_ru;
    }

    public void setPujigat_kar_yogya_kharid_kar_ru(String pujigat_kar_yogya_kharid_kar_ru) {
        this.pujigat_kar_yogya_kharid_kar_ru = pujigat_kar_yogya_kharid_kar_ru;
    }
}
