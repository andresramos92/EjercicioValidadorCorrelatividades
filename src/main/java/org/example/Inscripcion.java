package org.example;

import org.example.Alumno;
import org.example.Materia;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, Materia ... materias) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
        Collections.addAll(this.materias, materias);
    }

    public boolean aprobada() {
        return materias.stream()
                .allMatch(m -> m.getCorrelativas().stream()
                        .allMatch(alumno::estaAprobada));
    }
}