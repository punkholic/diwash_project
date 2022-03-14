package com.example.database.TableClasses;

public class SellBook {
    private int id;
    private int bujak_number;
    private int kharidkarta_esthae_number;
    private int nikasi_bastu_patra_no;

    private String date;
    private String nikasi_bastu_patra_miti;
    private String kharidkarta_nam;
    private String bastu_sewa_nam;
    private String bastu_sewa_praimad;
    private String jamma_bekri;
    private String esthaniya_kar_chutko_bikri;
    private String kar_yogya_bekri_muliya;
    private String kar_yogya_bekri_kar_ru;
    private String nikasi_bastu_mulya;
    private String nikasi_bastu_desh;
    private String jamma_bekri_1;
    private String jamma_bekri_2;
    private String esthaniya_kar_chutko_bikri_1;
    private String esthaniya_kar_chutko_bikri_2;
    private String kar_yogya_bekri_muliya_1;
    private String kar_yogya_bekri_muliya_2;
    private String kar_yogya_bekri_kar_ru_1;
    private String kar_yogya_bekri_kar_ru_2;

    public SellBook(){
        this(0, 0, 0, "2022-01-01", "", "", "", "", "", "", "", "", "", "");
    }

    public SellBook(int bujak_number, int kharidkarta_esthae_number, int nikasi_bastu_patra_no, String date, String nikasi_bastu_patra_miti, String kharidkarta_nam, String bastu_sewa_nam, String bastu_sewa_praimad, String jamma_bekri, String esthaniya_kar_chutko_bikri, String kar_yogya_bekri_muliya, String kar_yogya_bekri_kar_ru, String nikasi_bastu_mulya, String nikasi_bastu_desh) {
        this.id = -1;
        this.date = date;
        this.bujak_number = bujak_number;
        this.kharidkarta_nam = kharidkarta_nam;
        this.kharidkarta_esthae_number = kharidkarta_esthae_number;
        this.bastu_sewa_nam = bastu_sewa_nam;
        this.bastu_sewa_praimad = bastu_sewa_praimad;

        String[] splitedValue;
        this.jamma_bekri = jamma_bekri;
        splitedValue = split(this.jamma_bekri);
        this.jamma_bekri_1 = splitedValue[0]; this.jamma_bekri_2 = splitedValue[1];

        this.esthaniya_kar_chutko_bikri = esthaniya_kar_chutko_bikri;
        splitedValue = split(this.esthaniya_kar_chutko_bikri);
        this.esthaniya_kar_chutko_bikri_1 = splitedValue[0]; this.esthaniya_kar_chutko_bikri_2 = splitedValue[1];

        this.kar_yogya_bekri_muliya = kar_yogya_bekri_muliya;
        splitedValue = split(this.kar_yogya_bekri_muliya);
        this.kar_yogya_bekri_muliya_1 = splitedValue[0]; this.kar_yogya_bekri_muliya_2 = splitedValue[1];

        this.kar_yogya_bekri_kar_ru = kar_yogya_bekri_kar_ru;
        splitedValue = split(this.kar_yogya_bekri_kar_ru);
        this.kar_yogya_bekri_kar_ru_1 = splitedValue[0]; this.kar_yogya_bekri_kar_ru_2 = splitedValue[1];

        this.nikasi_bastu_mulya = nikasi_bastu_mulya;
        this.nikasi_bastu_desh = nikasi_bastu_desh;
        this.nikasi_bastu_patra_no = nikasi_bastu_patra_no;
        this.nikasi_bastu_patra_miti = nikasi_bastu_patra_miti;
    }
    public String[] split(String toSplit){
        String[] toReturn = toSplit.split("\\|");
        if (toReturn.length != 2){
            return new String[]{toSplit, ""};
        }
        return toReturn;
    }

    public String getJamma_bekri_1() {
        return jamma_bekri_1;
    }

    public void setJamma_bekri_1(String jamma_bekri_1) {
        this.jamma_bekri_1 = jamma_bekri_1;
    }

    public String getJamma_bekri_2() {
        return jamma_bekri_2;
    }

    public void setJamma_bekri_2(String jamma_bekri_2) {
        this.jamma_bekri_2 = jamma_bekri_2;
    }

    public String getEsthaniya_kar_chutko_bikri_1() {
        return esthaniya_kar_chutko_bikri_1;
    }

    public void setEsthaniya_kar_chutko_bikri_1(String esthaniya_kar_chutko_bikri_1) {
        this.esthaniya_kar_chutko_bikri_1 = esthaniya_kar_chutko_bikri_1;
    }

    public String getEsthaniya_kar_chutko_bikri_2() {
        return esthaniya_kar_chutko_bikri_2;
    }

    public void setEsthaniya_kar_chutko_bikri_2(String esthaniya_kar_chutko_bikri_2) {
        this.esthaniya_kar_chutko_bikri_2 = esthaniya_kar_chutko_bikri_2;
    }

    public String getKar_yogya_bekri_muliya_1() {
        return kar_yogya_bekri_muliya_1;
    }

    public void setKar_yogya_bekri_muliya_1(String kar_yogya_bekri_muliya_1) {
        this.kar_yogya_bekri_muliya_1 = kar_yogya_bekri_muliya_1;
    }

    public String getKar_yogya_bekri_muliya_2() {
        return kar_yogya_bekri_muliya_2;
    }

    public void setKar_yogya_bekri_muliya_2(String kar_yogya_bekri_muliya_2) {
        this.kar_yogya_bekri_muliya_2 = kar_yogya_bekri_muliya_2;
    }

    public String getKar_yogya_bekri_kar_ru_1() {
        return kar_yogya_bekri_kar_ru_1;
    }

    public void setKar_yogya_bekri_kar_ru_1(String kar_yogya_bekri_kar_ru_1) {
        this.kar_yogya_bekri_kar_ru_1 = kar_yogya_bekri_kar_ru_1;
    }

    public String getKar_yogya_bekri_kar_ru_2() {
        return kar_yogya_bekri_kar_ru_2;
    }

    public void setKar_yogya_bekri_kar_ru_2(String kar_yogya_bekri_kar_ru_2) {
        this.kar_yogya_bekri_kar_ru_2 = kar_yogya_bekri_kar_ru_2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBujak_number() {
        return bujak_number;
    }

    public void setBujak_number(int bujak_number) {
        this.bujak_number = bujak_number;
    }

    public int getKharidkarta_esthae_number() {
        return kharidkarta_esthae_number;
    }

    public void setKharidkarta_esthae_number(int kharidkarta_esthae_number) {
        this.kharidkarta_esthae_number = kharidkarta_esthae_number;
    }

    public int getNikasi_bastu_patra_no() {
        return nikasi_bastu_patra_no;
    }

    public void setNikasi_bastu_patra_no(int nikasi_bastu_patra_no) {
        this.nikasi_bastu_patra_no = nikasi_bastu_patra_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNikasi_bastu_patra_miti() {
        return nikasi_bastu_patra_miti;
    }

    public void setNikasi_bastu_patra_miti(String nikasi_bastu_patra_miti) {
        this.nikasi_bastu_patra_miti = nikasi_bastu_patra_miti;
    }

    public String getKharidkarta_nam() {
        return kharidkarta_nam;
    }

    public void setKharidkarta_nam(String kharidkarta_nam) {
        this.kharidkarta_nam = kharidkarta_nam;
    }

    public String getBastu_sewa_nam() {
        return bastu_sewa_nam;
    }

    public void setBastu_sewa_nam(String bastu_sewa_nam) {
        this.bastu_sewa_nam = bastu_sewa_nam;
    }

    public String getBastu_sewa_praimad() {
        return bastu_sewa_praimad;
    }

    public void setBastu_sewa_praimad(String bastu_sewa_praimad) {
        this.bastu_sewa_praimad = bastu_sewa_praimad;
    }

    public String getJamma_bekri() {
        return jamma_bekri;
    }

    public void setJamma_bekri(String jamma_bekri) {
        this.jamma_bekri = jamma_bekri;
    }

    public String getEsthaniya_kar_chutko_bikri() {
        return esthaniya_kar_chutko_bikri;
    }

    public void setEsthaniya_kar_chutko_bikri(String esthaniya_kar_chutko_bikri) {
        this.esthaniya_kar_chutko_bikri = esthaniya_kar_chutko_bikri;
    }

    public String getKar_yogya_bekri_muliya() {
        return kar_yogya_bekri_muliya;
    }

    public void setKar_yogya_bekri_muliya(String kar_yogya_bekri_muliya) {
        this.kar_yogya_bekri_muliya = kar_yogya_bekri_muliya;
    }

    public String getKar_yogya_bekri_kar_ru() {
        return kar_yogya_bekri_kar_ru;
    }

    public void setKar_yogya_bekri_kar_ru(String kar_yogya_bekri_kar_ru) {
        this.kar_yogya_bekri_kar_ru = kar_yogya_bekri_kar_ru;
    }

    public String getNikasi_bastu_mulya() {
        return nikasi_bastu_mulya;
    }

    public void setNikasi_bastu_mulya(String nikasi_bastu_mulya) {
        this.nikasi_bastu_mulya = nikasi_bastu_mulya;
    }

    public String getNikasi_bastu_desh() {
        return nikasi_bastu_desh;
    }

    public void setNikasi_bastu_desh(String nikasi_bastu_desh) {
        this.nikasi_bastu_desh = nikasi_bastu_desh;
    }
}
