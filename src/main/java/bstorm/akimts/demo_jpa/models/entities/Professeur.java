package bstorm.akimts.demo_jpa.models.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Professeur {

    @Id
    @Column(name = "professor_id", columnDefinition = "INT(11)" )
    private long id;

    @Column(name = "professor_name", length = 30)
    private String name;

    private String surname;


}
