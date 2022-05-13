package ru.mirea.coffeeshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item extends BaseEntity {
    protected String title;
    protected int cost;
    @Column(columnDefinition = "TEXT")
    protected String description;
}
