package org.bohdan.moneytracker.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@Table(name = "entries")
public class Entrie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "note")
    private String note;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "category")
    private String category;

    @Column(name = "currency")
    private String currency;

    @Column(name = "type")
    private String type;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "date")
    private Date date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "walletId")
    private Wallet wallet;
}
