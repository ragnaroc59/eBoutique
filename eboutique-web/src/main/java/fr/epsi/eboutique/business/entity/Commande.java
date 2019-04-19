package fr.epsi.eboutique.business.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="Commande")
public class Commande {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "identifier")
  private Long identifier;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "produit", cascade = CascadeType.ALL)
  private Collection<CommandeLigne> lignes;

  @Column(name = "dateCreation")
  private LocalDate dateCreation;

  public Collection<CommandeLigne> getLignes() {
    return lignes;
  }

  public void setLignes(Collection<CommandeLigne> lignes) {
    this.lignes = lignes;
  }

  public LocalDate getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(LocalDate dateCreation) {
    this.dateCreation = dateCreation;
  }

  public Long getIdentifier() {
    return identifier;
  }

  public void setIdentifier(Long identifier) {
    this.identifier = identifier;
  }
  
  
}
