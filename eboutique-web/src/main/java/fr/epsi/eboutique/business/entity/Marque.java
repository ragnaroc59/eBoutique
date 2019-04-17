package fr.epsi.eboutique.business.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Marque")
public class Marque {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "identifier")
  private Long identifier;

  @Column
  private String libelle;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "marque", cascade = CascadeType.ALL)
  private List<Produit> produits;

  public Long getIdentifier() {
    return identifier;
  }

  public void setIdentifier(Long identifier) {
    this.identifier = identifier;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public List<Produit> getProduits() {
    return produits;
  }

  public void setProduits(List<Produit> produits) {
    this.produits = produits;
  }

}
