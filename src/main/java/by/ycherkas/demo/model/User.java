package by.ycherkas.demo.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column
    private String name;

    @Column
    private String secondName;

    @Column
    private String modelAuto;

    @Column
    private String numberAuto;

    @Column
    private String problems;

//    @Column
//    private int numberPhone;


}

