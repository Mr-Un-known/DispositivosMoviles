package com.example.proyectomovil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

/**
 * Cada respuesta correcta debe existir tal cual entre sus 4 opciones. Un espacio
 * sobrante en "Tokio " hacía que esa pregunta nunca se pudiera acertar.
 */
public class QuestionsTest {

    private final Questions q = new Questions();

    @Test
    public void lasTresTablasTienenElMismoTamano() {
        assertEquals(q.mQuestions.length, q.mChoices.length);
        for (int i = 0; i < q.mChoices.length; i++) {
            assertEquals("la pregunta " + i + " no tiene 4 opciones", 4, q.mChoices[i].length);
        }
    }

    @Test
    public void cadaRespuestaCorrectaEstaEntreSusOpciones() {
        for (int i = 0; i < q.mQuestions.length; i++) {
            String correcta = q.getCorrectAnswer(i);
            String[] opciones = {q.getChoice1(i), q.getChoice2(i), q.getChoice3(i), q.getChoice4(i)};
            assertTrue(
                    "pregunta " + i + " (" + q.getQuestion(i) + ") es imposible de acertar: "
                            + "respuesta=<" + correcta + "> opciones=" + Arrays.toString(opciones),
                    Arrays.asList(opciones).contains(correcta));
        }
    }
}
