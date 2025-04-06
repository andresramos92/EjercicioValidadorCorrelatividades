package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Test para comprobar si una Inscripcion esta aprobada")
    void testInscripcionAprobada() {
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        paradigmas.agregarCorrelativa(algoritmos);

        Alumno juan = new Alumno("Juan");
        juan.agregarMateriaAprobada(algoritmos);

        Inscripcion inscripcion = new Inscripcion(juan, paradigmas);
        boolean resultado = inscripcion.aprobada();

        if (resultado) {
            System.out.println("✅ La inscripción fue aprobada correctamente.");
        } else {
            System.out.println("❌ La inscripción fue rechazada.");
        }

        assertTrue(inscripcion.aprobada(), "La inscripción debería estar aprobada");
    }

    @Test
    @DisplayName("Test para comprobar si una Inscripcion esta rechazada")
    void testInscripcionRechazada() {
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        paradigmas.agregarCorrelativa(algoritmos);

        Alumno maria = new Alumno("Maria"); // No aprobó Algoritmos

        Inscripcion inscripcion = new Inscripcion(maria, paradigmas);
        assertFalse(inscripcion.aprobada(), "La inscripción debería ser rechazada");
    }

    @Test
    @DisplayName("Test para comprobar si una Inscripcion esta aprobada con varias materias")
    void testInscripcionConMultiplesMateriasAprobada() {
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia diseño = new Materia("Diseño de Sistemas");
        Materia analisis1 = new Materia("Analisis1");
        Materia analisis2 = new Materia("Analisis2");
        Materia ingles1 = new Materia("Ingles1");
        Materia ingles2 = new Materia("Ingles2");


        paradigmas.agregarCorrelativa(algoritmos);
        diseño.agregarCorrelativa(paradigmas);
        analisis2.agregarCorrelativa(analisis1);
        ingles2.agregarCorrelativa(ingles1);

        Alumno andres = new Alumno("Andres");
        andres.agregarMateriaAprobada(algoritmos);
        andres.agregarMateriaAprobada(paradigmas);
        andres.agregarMateriaAprobada(analisis1);
        andres.agregarMateriaAprobada(ingles1);


        Inscripcion inscripcion = new Inscripcion(andres, diseño, analisis2, ingles2);

        boolean resultado = inscripcion.aprobada();

        if (resultado) {
            System.out.println("✅ La inscripción fue aprobada correctamente.");
        } else {
            System.out.println("❌ La inscripción fue rechazada.");
        }
        assertTrue(inscripcion.aprobada(), "La inscripción debería estar aprobada");
    }

    @Test
    @DisplayName("Test para comprobar si una Inscripcion esta aprobada con varias materias")
    void testInscripcionConMultiplesMateriasRechazada() {
        Materia algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        Materia paradigmas = new Materia("Paradigmas de Programación");
        Materia diseño = new Materia("Diseño de Sistemas");
        Materia analisis1 = new Materia("Analisis1");
        Materia analisis2 = new Materia("Analisis2");
        Materia ingles1 = new Materia("Ingles1");
        Materia ingles2 = new Materia("Ingles2");


        paradigmas.agregarCorrelativa(algoritmos);
        diseño.agregarCorrelativa(paradigmas);
        analisis2.agregarCorrelativa(analisis1);
        ingles2.agregarCorrelativa(ingles1);

        Alumno pedro = new Alumno("Pedro");
        pedro.agregarMateriaAprobada(algoritmos);
        pedro.agregarMateriaAprobada(paradigmas);

        Inscripcion inscripcion = new Inscripcion(pedro, diseño, analisis2, ingles2);
        assertFalse(inscripcion.aprobada(), "La inscripción debería estar rechazada");
    }
}
