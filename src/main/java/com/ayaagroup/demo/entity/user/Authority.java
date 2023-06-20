package com.ayaagroup.demo.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/********************* Impppp note: u should make the table of user_authorities manual in the DB ***********************/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authority_id;

    private String name;

//    @ManyToMany(mappedBy="authorities")
//    private Set<User> users = new HashSet<User>();
}
