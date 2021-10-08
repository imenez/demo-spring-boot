package com.imenez.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kisi_adres")
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adres implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_kisi_adres", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(length = 500, name = "adres")
    private String adres;

    @Getter
    @Setter
    @Enumerated
    private AdresTip adresTip;

    @Getter
    @Setter
    @Column(name = "aktif")
    private Boolean aktif;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;

    public enum AdresTip{
        EV_ADRES,
        IS_ADRES,
        DIGER
    }
}
