package net.ent.etrs.megamovies.model.entities;

import lombok.*;
import net.ent.etrs.megamovies.model.entities.references.ConstantesMetier;
import net.ent.etrs.megamovies.model.entities.references.Genre;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REALISATEUR", uniqueConstraints = @UniqueConstraint(name = "REALISATEUR__NOM__UK", columnNames = "NOM"))


@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Realisateur extends AbstractEntity {
    @Getter
    @Setter

    @NotBlank(message = ConstantesMetier.MSG_REALISATEUR_NOM_VIDE)
    @Size(min = 3, message = ConstantesMetier.MSG_REALISATEUR_NOM_TAILLE)
    @Column(name = "NOM", nullable = false)
    private String nom;


    @Enumerated(EnumType.STRING)
    @ElementCollection
    @JoinTable(name = "REALISATEUR_GENRE", foreignKey = @ForeignKey(name = "REALISATEUR_ID"))
    @Column(name = "GENRE", nullable = false, length = 50)
    private Set<Genre> genres = new HashSet<>();


}
