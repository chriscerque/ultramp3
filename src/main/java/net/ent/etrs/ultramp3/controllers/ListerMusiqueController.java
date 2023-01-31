package net.ent.etrs.ultramp3.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.ent.etrs.ultramp3.commons.utils.jxf.AlerteUtils;
import net.ent.etrs.ultramp3.commons.utils.jxf.FxmlUtils;
import net.ent.etrs.ultramp3.model.entities.Musique;
import net.ent.etrs.ultramp3.model.entities.references.Genre;
import net.ent.etrs.ultramp3.model.exceptions.BusinessException;
import net.ent.etrs.ultramp3.view.references.Screens;

import java.time.LocalDate;
import java.util.Objects;

public class ListerMusiqueController extends AbstractController {


    private final ObservableList<Musique> olstMusiques = FXCollections.observableArrayList();
    private final ObservableList<Genre> olstGenres = FXCollections.observableArrayList();
    @FXML
    public TableView<Musique> tvMusiques;
    @FXML
    public TableColumn<Musique, String> tcTitre;
    @FXML
    public TableColumn<Musique, LocalDate> tcDateSortie;
    @FXML
    public TableColumn<Musique, Genre> tcGenre;
    @FXML
    public TextField tfRechercheTitre;
    @FXML
    public ComboBox<Genre> cbxGenre;
    private FilteredList<Musique> filteredListMusique = new FilteredList<>(olstMusiques);

    @FXML
    public void initialize() {
        initOLstMusiques();
        initOLstGenre();
        initRechercheTitre();

        chargerTvMusiques();
    }

    private void initOLstMusiques() {

        try {
            this.olstMusiques.clear();
            this.olstMusiques.addAll(super.facadeMetierMusique.findAll());
        } catch (BusinessException e) {
            AlerteUtils.afficherExceptionDansAlerte(e, Alert.AlertType.ERROR);
        }
    }


    private void initOLstGenre() {
        this.olstGenres.clear();
        this.olstGenres.addAll(Genre.values());
    }

    private void initRechercheTitre() {
        this.tfRechercheTitre.textProperty().addListener((observable, oldValue, newValue) -> {
            this.filteredListMusique.setPredicate(film -> {

                return predicatFiltreLstFilms(newValue, film);
            });
        });
    }

    private boolean predicatFiltreLstFilms(String newValue, Musique musique) {
        if (Objects.isNull(newValue) || newValue.isEmpty()) {
            return true;
        }
        return musique.getTitre().toUpperCase().contains(newValue.toUpperCase());
    }


    private void chargerTvMusiques() {
        this.tvMusiques.setItems(this.filteredListMusique);

        this.tcTitre.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getTitre()));

        this.tcDateSortie.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getDateSortie()));

        this.tcGenre.setCellValueFactory((param) -> new SimpleObjectProperty<>(param.getValue().getGenre()));

//		this.tcDateSortie.setCellFactory(a -> new TextFieldTableCell<Film, LocalDate>(new LocalDateJFXConverter()));

        this.tvMusiques.setRowFactory(r -> creationRow(r));

    }

    private TableRow<Musique> creationRow(TableView<Musique> r) {
        TableRow<Musique> row = new TableRow<>();

        row.emptyProperty().addListener((obs, wasEmpty, isEmpty) -> {
            if (isEmpty) {
                row.setContextMenu(null);
            } else {
                row.setContextMenu(creationMenuContextuel());
            }
        });
        return row;
    }

    private ContextMenu creationMenuContextuel() {

        // création du menu contextuel
        ContextMenu contextMenu = new ContextMenu();
        // création du/des options du menu contextuel
        MenuItem itemModifier = new MenuItem("Modifier");
        MenuItem itemSupprimer = new MenuItem("Supprimer");
        MenuItem itemEcouter = new MenuItem("Ecouter");
        // mappage de la méthode supprimer() sur le menuItem
        itemModifier.setOnAction(c -> modifierMusique());
        itemSupprimer.setOnAction(c -> supprimerMusique());
        itemEcouter.setOnAction(c -> ecouter());
        // ajout du menuItem au contextMenu
        contextMenu.getItems().add(itemModifier);
        contextMenu.getItems().add(itemSupprimer);
        contextMenu.getItems().add(itemEcouter);

        return contextMenu;

    }

    private void modifierMusique() {
        FxmlUtils.chargerScene(Screens.SCREEN_GERER_MUSIQUE, new GererMusiqueController(this.tvMusiques.getSelectionModel().getSelectedItem()));
    }

    private void supprimerMusique() {
        try {
            super.facadeMetierMusique.delete(this.tvMusiques.getSelectionModel().getSelectedItem());
            this.initOLstMusiques();
        } catch (BusinessException e) {
            AlerteUtils.afficherMessageDansAlerte(e.getMessage(), Alert.AlertType.WARNING);
        }
    }

    private void ecouter() {
        //TODO
    }


}
