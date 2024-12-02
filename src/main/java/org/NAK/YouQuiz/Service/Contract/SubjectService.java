package org.NAK.YouQuiz.Service.Contract;

import org.NAK.YouQuiz.DTO.Subject.SubjectDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseSharedDTO;

import java.util.List;

public interface SubjectService {

    SubjectResponseSharedDTO createSubject(SubjectDTO subject);
    SubjectResponseDTO updateSubject(Long id,SubjectDTO subject);
    void deleteSubject(Long id);
    SubjectResponseDTO getSubject(Long id);
    List<SubjectResponseDTO> getSubjects();
}
