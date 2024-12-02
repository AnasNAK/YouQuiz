package org.NAK.YouQuiz.Mapper;

import org.NAK.YouQuiz.DTO.Subject.SubjectDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface SubjectMapper {

    Subject toSubject(SubjectDTO subjectDTO);
    SubjectResponseDTO toSubjectResponseDTO(Subject subject);
    SubjectResponseSharedDTO toSubjectResponseSharedDTO(Subject subject);
}
