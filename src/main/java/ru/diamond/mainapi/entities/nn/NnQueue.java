package ru.diamond.mainapi.entities.nn;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "colors", schema = "nn_queue")
public class NnQueue {

    @Id
    @Column(name = "uuid")
    @GeneratedValue(generator = "UUID")
    private UUID uuid;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "img_path")
    private String imgPath;
}
