package fr.epsi.eboutique.business.entity;

import javax.persistence.*;

@Entity
@Table(name="CommandeLigne")
public class CommandeLigne {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "identifier")
  private Long identifier;

  @ManyToOne(fetch = FetchType.EAGER)
  private Produit produit;

  @Column(name="quantite")
  private int quantite;

  @Column(name="commandeId")
  private Long commandeId;

  public Produit getProduit() {
    return produit;
  }

  public void setProduit(Produit produit) {
    this.produit = produit;
  }

  public int getQuantite() {
    return quantite;
  }

  public void setQuantite(int quantite) {
    this.quantite = quantite;
  }


  public Long getCommandeId() {
    return commandeId;
  }

  public void setCommandeId(Long commandeId) {
    this.commandeId = commandeId;
  }
}
