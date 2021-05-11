package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "entityA"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityA {
    @Id
    @SequenceGenerator(
            name = "entityA_sequence",
            sequenceName = "entityA_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entityA_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "attributeA", nullable = false, columnDefinition = "TEXT")
    private String attributeA;
    @Column(name = "attributeB", nullable = false)
    private Long attributeB;


}
