package fr.epsi.eboutique.business.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Produit")
public class Produit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long identifier;

  @Column
  private String libelle;

  @Column
  private String description;

  @Column
  private BigDecimal prix;

  @Column
  private String image;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "marque_id")
  private Marque marque;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrix() {
    return prix;
  }

  public void setPrix(BigDecimal prix) {
    this.prix = prix;
  }

  public Marque getMarque() {
    return marque;
  }

  public void setMarque(Marque marque) {
    this.marque = marque;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
