package com.mafe.gestion_estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mafe.gestion_estudiantes.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
