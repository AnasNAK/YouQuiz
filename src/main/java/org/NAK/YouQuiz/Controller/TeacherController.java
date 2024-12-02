package org.NAK.YouQuiz.Controller;

import org.NAK.YouQuiz.DTO.Teacher.TeacherDTO;
import org.NAK.YouQuiz.Service.Contract.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {


public final TeacherService teacherService;

public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
}

@PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
    TeacherDTO teacher = teacherService.createTeacher(teacherDTO);
    return new ResponseEntity<>(teacher, HttpStatus.CREATED);
}

@GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
    List<TeacherDTO> teachers = teacherService.getTeachers();
    return new ResponseEntity<>(teachers, HttpStatus.OK);
}

@GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
    TeacherDTO teacher = teacherService.getTeacherById(id);
    return new ResponseEntity<>(teacher, HttpStatus.OK);
}

@PatchMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
    TeacherDTO teacher = teacherService.updateTeacher(id, teacherDTO);
    return new ResponseEntity<>(teacher, HttpStatus.ACCEPTED);

}

@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
    teacherService.deleteTeacher(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
