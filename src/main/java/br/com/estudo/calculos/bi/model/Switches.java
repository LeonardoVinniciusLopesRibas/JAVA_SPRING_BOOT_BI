package br.com.estudo.calculos.bi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Entity(name = "table_inv_switches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Switches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registro;

    private Date data;

    @Column(length = 9)
    private String hora;

    @Column(length = 30)
    private String hostname;

    @Column(length = 16)
    private String ip_address;

    @Column(length = 18)
    private String mac_address;

    @Column(length = 20)
    private String marca;

    @Column(length = 20)
    private String modelo;

    @Column(length = 20)
    private String num_serie;

    @Column(length = 20)
    private String versao;

    @Column(length = 10)
    private String imobilizado;


}
