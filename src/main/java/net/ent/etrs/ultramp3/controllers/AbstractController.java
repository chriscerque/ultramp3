package net.ent.etrs.ultramp3.controllers;


import javafx.application.Platform;
import javafx.scene.control.Alert;
import net.ent.etrs.ultramp3.commons.utils.jxf.AlerteUtils;
import net.ent.etrs.ultramp3.model.facades.FacadeMetierFactory;
import net.ent.etrs.ultramp3.model.facades.FacadeMetierMusique;
import net.ent.etrs.ultramp3.model.facades.FacadeMetierCompositeur;
import net.ent.etrs.ultramp3.view.references.ConstanteView;

public abstract class AbstractController {
    protected static FacadeMetierMusique facadeMetierMusique;
    protected static FacadeMetierCompositeur facadeMetierCompositeur;

    public AbstractController() {
        try {
            facadeMetierMusique = FacadeMetierFactory.fabriquerFacadeMetierMusique();
            facadeMetierCompositeur = FacadeMetierFactory.fabriquerFacadeMetierCompositeur();
        } catch (Exception e) {
            e.printStackTrace();
            AlerteUtils.afficherMessageDansAlerte(e.getMessage(), Alert.AlertType.INFORMATION);
        }

    }


    protected void quitter() {
        boolean sortie = AlerteUtils.afficherMessageDansAlerte(ConstanteView.CONFIRMATION_DIALOG, ConstanteView.CONFIRMATION,
                ConstanteView.CONFIRMATION_QUITTER, Alert.AlertType.CONFIRMATION);

        if (sortie) {
            System.out.println("Sortie de l'application...");
            Platform.exit();
        }
    }

    public void aPropos() {
        AlerteUtils.afficherMessageDansAlerte("Information Dialog", "Copyright", "Made by CQA", Alert.AlertType.INFORMATION);
    }

}
