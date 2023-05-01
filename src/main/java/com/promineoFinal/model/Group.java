package com.promineoFinal.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@Entity
@Table(name = "musical_groups")
@ApiModel(description = "Represents a musical group entity")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long musicalGroupId;

    @Column(name = "name")
    private String name;

    public Group() {}

    public Group(String name) {
        this.name = name;
    }

    public Object getId() {
        return musicalGroupId;
    }
    
    @OneToMany(mappedBy = "group")
    private List<Student> students;

}
