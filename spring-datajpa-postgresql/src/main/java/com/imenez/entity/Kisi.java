package com.imenez.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kisi")
@EqualsAndHashCode(of = {"id"})
public class Kisi {

    @Id
    @SequenceGenerator(name = "seq_kisi", allocationSize = 1, sequenceName = "SEQ_KISI")
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(length = 100, name = "ad")
    private String ad;

    @Getter
    @Setter
    @Column(length = 100, name = "soyad")
    private String soyad;

    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    @Getter
    @Setter
    private List<Adres> adresList;




}
