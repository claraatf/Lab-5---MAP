import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Ator;
import org.example.Camera;
import org.example.Cinegrafista;
import org.example.Diretor;
import org.example.Produtor;
import org.example.Roteirista;

public class TestFuncoes {

    Ator Maria_Clara_Torres;
    Camera Jose_Ronaldo;
    Cinegrafista Sabrina_Souto;
    Diretor Paulo_Eduardo;
    Produtor Fernanda_Torres;
    Roteirista Rosane_Svartman;

    @BeforeEach
    public void setup(){

        Maria_Clara_Torres = new Ator();
        Jose_Ronaldo = new Camera();
        Sabrina_Souto = new Cinegrafista();
        Paulo_Eduardo = new Diretor();
        Fernanda_Torres = new Produtor();
        Rosane_Svartman = new Roteirista();

    }

    @Test
    void testGetDescricaoAssertTrue(){

        assertEquals("Ator", Maria_Clara_Torres.getDescricao());
        assertEquals("Camera", Jose_Ronaldo.getDescricao());
        assertEquals("Cinegrafista", Sabrina_Souto.getDescricao());
        assertEquals("Diretor", Paulo_Eduardo.getDescricao());
        assertEquals("Produtor", Fernanda_Torres.getDescricao());
        assertEquals("Roteirista", Rosane_Svartman.getDescricao());

    }

    @Test
    public void testGetDescricaoAsserFalse(){

        assertNotEquals("Camera", Maria_Clara_Torres.getDescricao());
        assertNotEquals("Cinegrafista", Maria_Clara_Torres.getDescricao());
        assertNotEquals("Diretor", Maria_Clara_Torres.getDescricao());
        assertNotEquals("Produtor", Maria_Clara_Torres.getDescricao());
        assertNotEquals("Roteirista", Maria_Clara_Torres.getDescricao());

        assertNotEquals("Ator", Jose_Ronaldo.getDescricao());
        assertNotEquals("Cinegrafista", Jose_Ronaldo.getDescricao());
        assertNotEquals("Diretor", Jose_Ronaldo.getDescricao());
        assertNotEquals("Produtor", Jose_Ronaldo.getDescricao());
        assertNotEquals("Roteirista", Jose_Ronaldo.getDescricao());

        assertNotEquals("Ator", Sabrina_Souto.getDescricao());
        assertNotEquals("Diretor", Sabrina_Souto.getDescricao());
        assertNotEquals("Camera", Sabrina_Souto.getDescricao());
        assertNotEquals("Produtor", Sabrina_Souto.getDescricao());
        assertNotEquals("Roteirista", Sabrina_Souto.getDescricao());

        assertNotEquals("Ator", Paulo_Eduardo.getDescricao());
        assertNotEquals("Cinegrafista", Paulo_Eduardo.getDescricao());
        assertNotEquals("Camera", Paulo_Eduardo.getDescricao());
        assertNotEquals("Produtor", Paulo_Eduardo.getDescricao());
        assertNotEquals("Roteirista", Paulo_Eduardo.getDescricao());

        assertNotEquals("Ator", Fernanda_Torres.getDescricao());
        assertNotEquals("Diretor", Fernanda_Torres.getDescricao());
        assertNotEquals("Camera", Fernanda_Torres.getDescricao());
        assertNotEquals("Cinegrafista", Fernanda_Torres.getDescricao());
        assertNotEquals("Roteirista", Fernanda_Torres.getDescricao());

        assertNotEquals("Ator", Rosane_Svartman.getDescricao());
        assertNotEquals("Diretor", Rosane_Svartman.getDescricao());
        assertNotEquals("Camera", Rosane_Svartman.getDescricao());
        assertNotEquals("Produtor", Rosane_Svartman.getDescricao());
        assertNotEquals("Cinegrafista", Rosane_Svartman.getDescricao());

    }

}
