package by.malahovski.hometask28.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String address;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="storage_id")
    private Storage storage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shelf_id")
    private Shelf shelf;
}
