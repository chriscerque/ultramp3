package net.ent.etrs.ultramp3.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import net.ent.etrs.ultramp3.model.entities.Compositeur;
import net.ent.etrs.ultramp3.model.entities.Musique;
import net.ent.etrs.ultramp3.model.entities.references.Genre;
import net.ent.etrs.ultramp3.model.exceptions.BusinessException;
import net.ent.etrs.ultramp3.view.converters.CompositeurConverter;

import java.util.Arrays;
import java.util.Objects;

public class GererMusiqueController extends AbstractController {
    final ObservableList<Genre> olstGenre = FXCollections.observableArrayList();
    final ObservableList<Compositeur> olstCompositeur = FXCollections.observableArrayList();
    @FXML
    public TextField tfTitre;
    @FXML
    public DatePicker dpDateSortie;
    @FXML
    public ComboBox<Genre> cbxGenre;
    @FXML
    public ComboBox<Compositeur> cbxCompositeur;
    @FXML
    public Button btnValider;
    private Musique musiqueAModifier;

    private boolean modification;

    public GererMusiqueController(Musique musique) {
        this.musiqueAModifier = musique;
        this.modification = Objects.nonNull(this.musiqueAModifier);
    }

    @FXML
    public void initialize() {
        initialiserFilm();
    }

    private void initGenre() {
        this.olstGenre.addAll(Arrays.asList(Genre.values()));
        this.cbxGenre.setItems(this.olstGenre);

    }

    private void initCompositeur() {
        try {
            this.olstCompositeur.addAll(super.facadeMetierCompositeur.readAll());
            this.cbxCompositeur.setConverter(new CompositeurConverter());
            this.cbxCompositeur.setItems(this.olstCompositeur);
        } catch (BusinessException e) {
            e.printStackTrace();
        }


    }

    private void initialiserFilm() {

        if (this.modification) {
            this.tfTitre.setText(this.musiqueAModifier.getTitre());
            this.cbxGenre.setValue(this.musiqueAModifier.getGenre());
            this.cbxCompositeur.setValue(this.musiqueAModifier.getCompositeur());

            this.btnValider.setText("Modifier");
        }
    }

}
