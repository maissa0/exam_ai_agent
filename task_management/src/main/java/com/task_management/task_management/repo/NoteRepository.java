package com.task_management.task_management.repo;


import com.task_management.task_management.entity.Note;
import com.task_management.task_management.entity.Note_Key;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Note_Key> { }