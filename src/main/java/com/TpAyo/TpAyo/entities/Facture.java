package com.TpAyo.TpAyo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    private Float montantRemise ;
    private Float montantFacture ;
    private Boolean active ;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFacture ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(mappedBy = "facture")
    private List<DetailFacture> detailFactures;
}
