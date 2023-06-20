package com.ayaagroup.demo.entity.prescription;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scan-result")
public class ScanResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scan_id")
    private Integer scanId;

    //pdf!!!!!!!!!!!!!!
    @Column(name = "scan_result")
    private String scanImage;



//    @JsonBackReference
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "test_id", insertable = false, updatable = false)
//    private LabScans labScans;

}
