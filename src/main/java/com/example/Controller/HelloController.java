package com.example.Controller;

import com.example.database.TableClasses.Article;
import com.example.database.TableClasses.PurchaseBook;
import com.example.database.TableClasses.SellBook;
import com.example.database.TableClasses.StockBook;
import com.example.gui.AutoCompleteTextField;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HelloController {
    private final String delimeter = "|";
    @FXML
    public Button purchaseAdd, sellingAdd, stockAdd, purchaseCancelEdit, sellCancelEdit, stockCancelEdit, addArticle, selectArticle;
    @FXML
    private TextField kharid_patra_no, kharid_chut_bastu_2, kharid_chut_bastu_1, kharid_aapurtikarta_no, kharid_aapurtikarta_nam, kharid_bastu_bibarad, kharid_bastuko_pramad, kharid_jamma_muliya, kharid_jamma_pae, kharid_kar_yogya_1, kharid_kar_yogya_2, kharid_kar_yogya_3, kharid_kar_yogya_4, kharid_jamma_1, kharid_jamma_2, kharid_kar_yogya_pauthari_1, kharid_kar_yogya_pauthari_2, kharid_kar_yogya_pauthari_3, kharid_kar_yogya_pauthari_4, kharid_kar_yogya_kharid_1, kharid_kar_yogya_kharid_2, kharid_kar_yogya_kharid_3, kharid_kar_yogya_kharid_4;
    @FXML
    private TextField bikri_bijak_no, bikri_kharidkartako_estae_lekha, bikri_kharidkarta_nam, bikri_sewako_nam, bikri_bastu_parimad, bikri_jamma_bikri_1, bikri_jamma_bikri_2, bikri_kar_yogya_mulya_1, bikri_kar_yogya_mulya_2, bikri_kar_yogya_kar_1, bikri_kar_yogya_kar_2, bikri_esthaniya_kar_chut_1, bikri_esthaniya_kar_chut_2, bikri_nikasi_bastu_mulya, bikri_nikasi_gariyeko_desh, bikri_nikasi_pragyapan_no, bikri_nikasi_pragyapan_miti;
    @FXML
    private TextField stock_bibarad, stock_di_jae_sankhiya, stock_sokh_sankhiya, stock_bises_bibarad, stock_prapta_sankhiya, stock_prapta_daar, stock_prapta_rakam;
    @FXML
    private TextField articleField;
    @FXML
    private DatePicker kharid_miti, bikri_miti, stock_miti;
    @FXML
    private TableView<PurchaseBook> purchaseTable;
    @FXML
    private TableView<SellBook> sellingTable;
    @FXML
    private TableView<StockBook> stockTable;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tab1, tab2, tab3, tab4, tab5, tab6;
    @FXML
    private int editId;
    @FXML
    private Label selectedArticleLabel;
    @FXML
    private AutoCompleteTextField set_article, searchArticle;

    private com.example.database.Model.PurchaseBook purchaseBookModel;
    private com.example.database.Model.StockBook stockBookModel;
    private com.example.database.Model.SellBook sellingBookModel;
    private com.example.database.Model.Article articleModel;

    public void initialize(){
        this.editId = 0;
        purchaseBookModel = new com.example.database.Model.PurchaseBook();
        stockBookModel = new com.example.database.Model.StockBook();
        sellingBookModel = new com.example.database.Model.SellBook();
        articleModel = new com.example.database.Model.Article();
        initTable();
        setEvents();
        renderArticles();
    }


    public ContextMenu getContextMenu(){
        MenuItem edit = new MenuItem("Edit");
        MenuItem delete = new MenuItem("Delete");
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().add(edit);
        contextMenu.getItems().add(separatorMenuItem);
        contextMenu.getItems().add(delete);

        edit.setOnAction(e -> {
            int selectedTab = tabPane.getSelectionModel().getSelectedIndex();
            tabPane.getSelectionModel().select(selectedTab - 1);
            switch (selectedTab){
                case 1:
                    PurchaseBook purchaseBook = purchaseTable.getSelectionModel().getSelectedItem();
                    editId = purchaseBook.getId();
                    setPurchaseFields(purchaseBook);
                    break;
                case 3:
                    SellBook sellBook = sellingTable.getSelectionModel().getSelectedItem();
                    editId = sellBook.getId();
                    setSellingField(sellBook);
                    break;
                case 5:
                    StockBook stockBook = stockTable.getSelectionModel().getSelectedItem();
                    editId = stockBook.getId();
                    setStockField(stockBook);
                    break;
            }
            editMode(true);
        });

        delete.setOnAction(e -> {
            int selectedTab = tabPane.getSelectionModel().getSelectedIndex();

            try {
                switch (selectedTab){
                    case 1:
                        PurchaseBook purchaseBook = purchaseTable.getSelectionModel().getSelectedItem();
                        purchaseBookModel.delete(purchaseBook.getId());
                        break;
                    case 3:
                        SellBook sellBook = sellingTable.getSelectionModel().getSelectedItem();
                        sellingBookModel.delete(sellBook.getId());
                        break;
                    case 5:
                        StockBook stockBook = stockTable.getSelectionModel().getSelectedItem();
                        stockBookModel.delete(stockBook.getId());
                        break;
                }
                renderTables();
            }catch (SQLException f){
                System.out.println(f.getMessage());
            }

        });
        return contextMenu;
    }
    public void initTable(){
        ContextMenu contextMenu = getContextMenu();

        purchaseTable.setContextMenu(contextMenu);
        sellingTable.setContextMenu(contextMenu);
        stockTable.setContextMenu(contextMenu);

        changeTableFont(purchaseTable);
        changeTableFont(sellingTable);
        changeTableFont(stockTable);

        renderTables();
    }
    public ArrayList<String> getArticles() throws SQLException{
        ArrayList<Article> articles = articleModel.get();
        ArrayList<String> articleData = new ArrayList<>();
        for (Article article : articles){
            articleData.add(article.getName());
        }
        return articleData;
    }
    public void renderArticles(){
        try {
            set_article.getEntries().addAll(getArticles());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void setEvents(){
        selectArticle.setOnAction(e -> {
            try {
                stockTable.getItems().removeAll(stockTable.getItems());
                boolean hasValue = false;
                ArrayList<StockBook> stockBooks = stockBookModel.search(searchArticle.getText());
                for(StockBook s : stockBooks){
                    hasValue = true;
                    System.out.println(s.getMiti());
                    stockTable.getItems().add(s);
                }
                if(hasValue) {
                    selectedArticleLabel.setText("Article: " + searchArticle.getText());
                }else{
                    selectedArticleLabel.setText("Article: None");
                }

            }catch (SQLException f){
                System.out.println(f.getMessage());
            }

        });


        addArticle.setOnAction(e -> {
            Article article = new Article(articleField.getText());
            try {
                articleModel.insert(article);
                renderArticles();
            }catch (SQLException f){
                System.out.println(f.getMessage());
            }
        });
        purchaseCancelEdit.setOnAction(e -> {
            setPurchaseFields(new PurchaseBook());
            editMode(false);
        });
        sellCancelEdit.setOnAction(e -> {
            setSellingField(new SellBook());
            editMode(false);
        });

        stockCancelEdit.setOnAction(e -> {
            setStockField(new StockBook());
            editMode(false);
        });

        purchaseAdd.setOnAction((e) -> {
            PurchaseBook purchaseBook = getPurchaseBook();
            try {
                if(purchaseAdd.getText().equalsIgnoreCase("add")){
                    purchaseBookModel.insert(purchaseBook);
                }else{
                    purchaseBook.setId(editId);
                    purchaseBookModel.update(purchaseBook);
                }
            }catch (SQLException f){
                f.printStackTrace();
            }
            editMode(false);
            renderTables();
        });
        sellingAdd.setOnAction((e) -> {
            SellBook sellBook = getSellBook();
            try {
                if(purchaseAdd.getText().equalsIgnoreCase("add")){
                    sellingBookModel.insert(sellBook);
                }else{
                    sellBook.setId(editId);
                    sellingBookModel.update(sellBook);
                }
            }catch (SQLException f){
                f.printStackTrace();
            }
            editMode(false);
            renderTables();
        });
        stockAdd.setOnAction((e) -> {
            StockBook stockBook = getStockBook();
            try {
                if(purchaseAdd.getText().equalsIgnoreCase("add")){
                    stockBookModel.insert(stockBook);
                }else{
                    stockBook.setId(editId);
                    stockBookModel.update(stockBook);
                }
            }catch (SQLException f){
                f.printStackTrace();
            }
            editMode(false);
            renderTables();
        });
        tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            if(editId != 0){
                editId = 0;
                editMode(false);
            }
            if(tabPane.getSelectionModel().getSelectedIndex() == 5){
                try {
                    searchArticle.getEntries().addAll(getArticles());
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public void renderTables(){
        stockTable.getItems().removeAll(stockTable.getItems());
        purchaseTable.getItems().removeAll(purchaseTable.getItems());
        sellingTable.getItems().removeAll(sellingTable.getItems());

        try {
            ArrayList<PurchaseBook> purchaseBooks = purchaseBookModel.get();
            for(PurchaseBook p : purchaseBooks){
                purchaseTable.getItems().add(p);
            }
            ArrayList<SellBook> sellBooks = sellingBookModel.get();
            for(SellBook s : sellBooks){
                sellingTable.getItems().add(s);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public LocalDate stringToDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        return LocalDate.parse(date, formatter);
    }

    public void setStockField(StockBook stockBook){
        stock_prapta_rakam.setText(stockBook.getReceipt_amount() + "");
        stock_miti.setValue(stringToDate(stockBook.getMiti()));
        stock_bibarad.setText(stockBook.getRemarks());
        stock_prapta_sankhiya.setText(stockBook.getReceipt_quantity());
        stock_prapta_daar.setText(stockBook.getReceipt_rate());
        stock_di_jae_sankhiya.setText(stockBook.getIssued_quantity());
        stock_sokh_sankhiya.setText(stockBook.getBalance_quantity());
        stock_bises_bibarad.setText(stockBook.getParticulars());
    }

    public void setSellingField(SellBook sellBook){
        bikri_miti.setValue(stringToDate(sellBook.getDate()));

        bikri_bijak_no.setText(sellBook.getBujak_number() + "");
        bikri_kharidkartako_estae_lekha.setText(sellBook.getKharidkarta_esthae_number() + "");
        bikri_nikasi_pragyapan_no.setText(sellBook.getNikasi_bastu_patra_no() + "");
        bikri_nikasi_pragyapan_miti.setText(sellBook.getNikasi_bastu_patra_miti());
        bikri_kharidkarta_nam.setText(sellBook.getKharidkarta_nam());
        bikri_sewako_nam.setText(sellBook.getBastu_sewa_nam());
        bikri_bastu_parimad.setText(sellBook.getBastu_sewa_praimad());

        bikri_jamma_bikri_1.setText(sellBook.getJamma_bekri_1());
        bikri_jamma_bikri_2.setText(sellBook.getJamma_bekri_2());

        bikri_esthaniya_kar_chut_1.setText(sellBook.getEsthaniya_kar_chutko_bikri_1());
        bikri_esthaniya_kar_chut_2.setText(sellBook.getEsthaniya_kar_chutko_bikri_2());

        bikri_kar_yogya_mulya_1.setText(sellBook.getKar_yogya_bekri_muliya_1());
        bikri_kar_yogya_mulya_2.setText(sellBook.getKar_yogya_bekri_muliya_2());

        bikri_kar_yogya_kar_1.setText(sellBook.getKar_yogya_bekri_kar_ru_1());
        bikri_kar_yogya_kar_2.setText(sellBook.getKar_yogya_bekri_kar_ru_2());

        bikri_nikasi_bastu_mulya.setText(sellBook.getNikasi_bastu_mulya());
        bikri_nikasi_gariyeko_desh.setText(sellBook.getNikasi_bastu_desh());
    }

    public void setPurchaseFields(PurchaseBook purchaseBook){
        kharid_miti.setValue(stringToDate(purchaseBook.getDate()));

        kharid_patra_no.setText(purchaseBook.getPragyapan_patra_number() + "");
        kharid_aapurtikarta_no.setText(purchaseBook.getAapurtikarta_esthati_number() + "");

        kharid_aapurtikarta_nam.setText(purchaseBook.getAapurtikarta_nam());
        kharid_bastu_bibarad.setText(purchaseBook.getKharid_pauthari_bastu());
        kharid_bastuko_pramad.setText(purchaseBook.getKharid_bastu_parimad());

        kharid_jamma_muliya.setText(purchaseBook.getJamma_kharid_1());
        kharid_jamma_pae.setText(purchaseBook.getJamma_kharid_2());

        kharid_chut_bastu_1.setText(purchaseBook.getKar_chut_bastu_1());
        kharid_chut_bastu_2.setText(purchaseBook.getKar_chut_bastu_2());

        kharid_kar_yogya_1.setText(purchaseBook.getKar_yogya_kharid_mulya_1());
        kharid_kar_yogya_2.setText(purchaseBook.getKar_yogya_kharid_mulya_2());
        kharid_kar_yogya_3.setText(purchaseBook.getKar_yogya_kharid_kar_ru_1());
        kharid_kar_yogya_4.setText(purchaseBook.getKar_yogya_kharid_kar_ru_2());

        kharid_kar_yogya_pauthari_1.setText(purchaseBook.getKar_yogya_pauthari_mulya_1());
        kharid_kar_yogya_pauthari_2.setText(purchaseBook.getKar_yogya_pauthari_mulya_2());
        kharid_kar_yogya_pauthari_3.setText(purchaseBook.getKar_yogya_pauthari_kar_ru_1());
        kharid_kar_yogya_pauthari_4.setText(purchaseBook.getKar_yogya_pauthari_kar_ru_2());

        kharid_kar_yogya_kharid_1.setText(purchaseBook.getPujigat_kar_yogya_kharid_mulya_1());
        kharid_kar_yogya_kharid_2.setText(purchaseBook.getPujigat_kar_yogya_kharid_mulya_2());
        kharid_kar_yogya_kharid_3.setText(purchaseBook.getPujigat_kar_yogya_kharid_kar_ru_1());
        kharid_kar_yogya_kharid_4.setText(purchaseBook.getPujigat_kar_yogya_kharid_kar_ru_2());

    }
    public void editMode(boolean isEdit){
        if(isEdit){
            purchaseCancelEdit.setVisible(true);
            sellCancelEdit.setVisible(true);
            stockCancelEdit.setVisible(true);
            purchaseAdd.setText("Edit");
            stockAdd.setText("Edit");
            sellingAdd.setText("Edit");
        }else{
            purchaseCancelEdit.setVisible(false);
            sellCancelEdit.setVisible(false);
            stockCancelEdit.setVisible(false);
            setSellingField(new SellBook());
            setPurchaseFields(new PurchaseBook());
            setStockField(new StockBook());
            purchaseAdd.setText("Add");
            sellingAdd.setText("Add");
            stockAdd.setText("Add");
        }
    }

    public SellBook getSellBook(){
        int bijak_no = this.convertToInt(bikri_bijak_no.getText());
        int kharidkartako_estae_lekha =  this.convertToInt(bikri_kharidkartako_estae_lekha.getText());
        int nikasi_pragyapan_no = this.convertToInt(bikri_nikasi_pragyapan_no.getText());
        String miti = bikri_miti.getValue().toString();
        String nikasi_pragyapan_miti = bikri_nikasi_pragyapan_miti.getText();
        String kharidkarta_nam = bikri_kharidkarta_nam.getText();
        String sewako_nam = bikri_sewako_nam.getText();
        String bastu_parimad = bikri_bastu_parimad.getText();
        String jamma_bikri = bikri_jamma_bikri_1.getText() + this.delimeter + bikri_jamma_bikri_2.getText();
        String esthaniya_kar_chut = bikri_esthaniya_kar_chut_1.getText() + this.delimeter + bikri_esthaniya_kar_chut_2.getText();
        String kar_yogya_mulya = bikri_kar_yogya_mulya_1.getText() + this.delimeter + bikri_kar_yogya_mulya_2.getText();
        String kar_yogya_kar = bikri_kar_yogya_kar_1.getText() + this.delimeter + bikri_kar_yogya_kar_2.getText();
        String nikasi_bastu_mulya = bikri_nikasi_bastu_mulya.getText();
        String nikasi_gariyeko_desh = bikri_nikasi_gariyeko_desh.getText();

        return new SellBook(bijak_no, kharidkartako_estae_lekha, nikasi_pragyapan_no, miti, nikasi_pragyapan_miti, kharidkarta_nam, sewako_nam, bastu_parimad, jamma_bikri, esthaniya_kar_chut, kar_yogya_mulya, kar_yogya_kar, nikasi_bastu_mulya, nikasi_gariyeko_desh);
    }

    public PurchaseBook getPurchaseBook(){
        String kharidMiti = kharid_miti.getValue().toString();
        int patra_no = this.convertToInt(kharid_patra_no.getText());
        int aapurtikarta_no = this.convertToInt(kharid_aapurtikarta_no.getText());

        String aapurtikarta_nam = kharid_aapurtikarta_nam.getText();
        String bastu_bibarad = kharid_bastu_bibarad.getText();
        String bastuko_pramad = kharid_bastuko_pramad.getText();

        String jamma_kharid = kharid_jamma_muliya.getText() + this.delimeter + kharid_jamma_pae.getText();

        String kar_chuut = kharid_chut_bastu_1.getText() + this.delimeter + kharid_chut_bastu_2.getText();

        String kharid_kar_yogya_mulya = kharid_kar_yogya_1.getText() + this.delimeter + kharid_kar_yogya_2.getText();
        String kharid_kar_yogya_kar = kharid_kar_yogya_3.getText() + this.delimeter + kharid_kar_yogya_4.getText();


        String kar_yogya_pauthari_mulya = kharid_kar_yogya_pauthari_1.getText() + this.delimeter + kharid_kar_yogya_pauthari_2.getText();
        String kar_yogya_pauthari_kar = kharid_kar_yogya_pauthari_3.getText() + this.delimeter + kharid_kar_yogya_pauthari_4.getText();

        String kar_yogya_kharid_mulya = kharid_kar_yogya_kharid_1.getText() + this.delimeter +  kharid_kar_yogya_kharid_2.getText();
        String kar_yogya_kharid_kar = kharid_kar_yogya_kharid_3.getText() + this.delimeter +  kharid_kar_yogya_kharid_4.getText();

        return new PurchaseBook(kharidMiti, patra_no, aapurtikarta_no, aapurtikarta_nam, bastu_bibarad, bastuko_pramad, jamma_kharid, kar_chuut, kharid_kar_yogya_mulya, kharid_kar_yogya_kar, kar_yogya_pauthari_mulya, kar_yogya_pauthari_kar, kar_yogya_kharid_mulya, kar_yogya_kharid_kar);
    }

    public StockBook getStockBook(){
        int prapta_rakam =  this.convertToInt(stock_prapta_rakam.getText());
        String miti = stock_miti.getValue().toString();
        String bibarad =  stock_bibarad.getText();
        String prapta_sankhiya =  stock_prapta_sankhiya.getText();
        String prapta_daar =  stock_prapta_daar.getText();
        String di_jae_sankhiya =  stock_di_jae_sankhiya.getText();
        String sokh_sankhiya =  stock_sokh_sankhiya.getText();
        String bises_bibarad =  stock_bises_bibarad.getText();
        String articalName = set_article.getText();
        return new StockBook(prapta_rakam, miti, bibarad, prapta_sankhiya, prapta_daar, di_jae_sankhiya, sokh_sankhiya, bises_bibarad, articalName);
    }

    public int convertToInt(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public <T> void changeTableFont(TableView<T> tableView){
        tableView.needsLayoutProperty().addListener((obs, old, needsLayout) -> {
            if (!needsLayout) {
                tableView.lookupAll(".column-header").stream().map(node -> (Region) node).forEach(column -> {
                    if (column.getProperties().get("fontLoaded") == null) {
                        column.lookupAll(".label").stream().map(node -> (Label) node).forEach(label -> label.setFont(new Font("System Regular", 14)));
                    }
                });
            }
        });
    }
}