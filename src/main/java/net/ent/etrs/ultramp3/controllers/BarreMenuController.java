package net.ent.etrs.ultramp3.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import net.ent.etrs.ultramp3.commons.utils.jxf.FxmlUtils;
import net.ent.etrs.ultramp3.view.references.Screens;

public class BarreMenuController extends AbstractController {
    @FXML
    private VBox laBarre;

    @FXML
    private MenuItem listerMusiques;

    @FXML
    private MenuItem ajouterMusique;

    @FXML
    private MenuItem quitter;


    @FXML
    public void quitter() {

        super.quitter();


    }

    @FXML
    public void listerMusiques() {

        FxmlUtils.chargerScene(laBarre.getScene(), Screens.SCREEN_LISTER_MUSIQUE, null);

    }

    @FXML
    public void ajouterMusique() {

        FxmlUtils.chargerScene(laBarre.getScene(), Screens.SCREEN_GERER_MUSIQUE, new GererMusiqueController(null));
    }

    @FXML
    public void apropos() {
        super.aPropos();
    }


}
