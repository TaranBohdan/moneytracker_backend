package org.bohdan.moneytracker.models.entities;

import lombok.Data;
import org.bohdan.moneytracker.models.enumerations.EntrieType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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

    @Column(name = "type")
    private EntrieType type;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "walletId")
    private Wallet wallet;
}
