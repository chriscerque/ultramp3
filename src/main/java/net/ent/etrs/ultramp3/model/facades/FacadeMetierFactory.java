package net.ent.etrs.ultramp3.model.facades;

public class FacadeMetierFactory {
    public static FacadeMetierMusique fabriquerFacadeMetierMusique() {
        return new FacadeMetierMusiqueImpl();
    }

    public static FacadeMetierCompositeur fabriquerFacadeMetierCompositeur() {
        return new FacadeMetierCompositeurImpl();
    }
}
