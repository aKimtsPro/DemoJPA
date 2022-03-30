package bstorm.akimts.demo_jpa.models.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cours {

    @Id
    @Column(name = "course_id", length = 8)
    private String id;

    @Column(name = "course_name", length = 200)
    private String name;

    @Column(name = "course_ects", columnDefinition = "DECIMAL(3,1)")
    private float ects;

    @Column(columnDefinition = "INT(11)")
    private long professorId;

}
