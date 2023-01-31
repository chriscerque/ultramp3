package net.ent.etrs.ultramp3.model.entities;

import lombok.*;
import net.ent.etrs.ultramp3.model.entities.references.ConstantesMetier;
import net.ent.etrs.ultramp3.model.entities.references.Genre;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPOSITEUR", uniqueConstraints = @UniqueConstraint(name = "COMPSITEUR__NOM__UK", columnNames = "NOM"))


@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Compositeur extends AbstractEntity {
    @Getter
    @Setter

    @NotBlank(message = ConstantesMetier.MSG_REALISATEUR_NOM_VIDE)
    @Size(min = 3, message = ConstantesMetier.MSG_REALISATEUR_NOM_TAILLE)
    @Column(name = "NOM", nullable = false)
    private String nom;


    @Enumerated(EnumType.STRING)
    @ElementCollection
    @JoinTable(name = "COMPOSITEUR_GENRE", foreignKey = @ForeignKey(name = "COMPOSITEUR_ID"))
    @Column(name = "GENRE", nullable = false, length = 50)
    private Set<Genre> genres = new HashSet<>();


}
