package by.malahovski.hometask28.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "number_row")
    private Integer numberOfRow;

    @Column
    private Integer number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;
}