package com.ayaagroup.demo.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

    private Integer PrescriptionId;

    private String diagnosisName;

    private String date;

    private String notes;

//    private SpecialistDoctor specialistDoctor;

//    private List<RequiredMedication> prescriptionDrugsEntities ;

//    private List<LabTests> labTests;
//
//    private List<LabScans> labScans;

//    public static PrescriptionDto toDto (PrescriptionEntity entity) {
//        return PrescriptionDto.builder()
//                .PrescriptionId(entity.getPrescriptionId())
//                .diagnosisName(entity.getDiagnosisName())
//                .date(entity.getDate())
//                .notes(entity.getNotes())
//                .specialistDoctor(entity.getSpecialistDoctor())
//                .prescriptionDrugsEntities(entity.getPrescriptionDrugsEntities())
//                .labTests(entity.getLabTests())
//                .labScans(entity.getLabScans())
//                .build();
//    }
}
