package net.ent.etrs.ultramp3.model.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import net.ent.etrs.ultramp3.model.entities.references.Genre;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MUSIQUE", uniqueConstraints = @UniqueConstraint(name = "MUSIQUE__TITRE__UK", columnNames = "TITRE"))

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
public class Musique extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "TITRE", nullable = false, length = 150)
    String titre;
    @Getter
    @Setter
    @Column(name = "DATE_SORTIE", nullable = false)
    LocalDate dateSortie;
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    @Column(name = "GENRE", nullable = false, length = 50)
    Genre genre;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "COMPOSITEUR_ID", nullable = false, foreignKey = @ForeignKey(name = "FILM__COMPOSITEUR_FK"))
    Compositeur compositeur;


}
