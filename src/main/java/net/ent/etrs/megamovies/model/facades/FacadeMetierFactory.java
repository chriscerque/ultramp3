package net.ent.etrs.megamovies.model.facades;

public class FacadeMetierFactory {
    public static FacadeMetierFilm fabriquerFacadeMetier() {
        return new FacadeMetierFilmImpl();
    }
}
