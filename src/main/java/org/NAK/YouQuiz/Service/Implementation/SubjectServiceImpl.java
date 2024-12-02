package org.NAK.YouQuiz.Service.Implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.NAK.YouQuiz.DTO.Subject.SubjectDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseDTO;
import org.NAK.YouQuiz.DTO.Subject.SubjectResponseSharedDTO;
import org.NAK.YouQuiz.Entity.Subject;
import org.NAK.YouQuiz.Mapper.SubjectMapper;
import org.NAK.YouQuiz.Repository.SubjectRepository;
import org.NAK.YouQuiz.Service.Contract.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    private final SubjectMapper subjectMapper;


    @Override
    public SubjectResponseSharedDTO createSubject(SubjectDTO subject) {
        Subject savedSubject = subjectMapper.toSubject(subject);
        subjectRepository.save(savedSubject);
        return subjectMapper.toSubjectResponseSharedDTO(savedSubject);
    }

    @Override
    public SubjectResponseDTO updateSubject(Long id, SubjectDTO subject) {
        Subject existedSubject = subjectRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Subject with id " + id + " not found"));

        Subject updatedSubject = subjectMapper.toSubject(subject);
        updatedSubject.setId(id);
        subjectRepository.save(updatedSubject);

        return subjectMapper.toSubjectResponseDTO(updatedSubject);
    }

    @Override
    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new EntityNotFoundException("Subject with id " + id + " not found");

        }

        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectResponseDTO getSubject(Long id) {
        return subjectRepository.findById(id)
                .map(subjectMapper::toSubjectResponseDTO)
                .orElseThrow(()-> new EntityNotFoundException("Subject with id " + id + " not found"));
    }

    @Override
    public List<SubjectResponseDTO> getSubjects() {
        return subjectRepository.findAll()
                .stream()
                .map(subjectMapper::toSubjectResponseDTO)
                .collect(Collectors.toList());
    }
}