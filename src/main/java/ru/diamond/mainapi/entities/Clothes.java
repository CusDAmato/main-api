package ru.diamond.mainapi.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clothes", schema = "diamond")
public class Clothes {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "UUID")
    private UUID uuid;

    @Column(name = "img_path")
    private String imgPath;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false, updatable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "print_id", nullable = false, updatable = false)
    private Print print;

}
