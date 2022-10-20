package es.edu.teis.sax;

import es.edu.teis.sax.handler.PersonaHandlerB;
import es.edu.teis.sax.model.Persona;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author a20vanesagp
 */
public class UD1_Actividad15B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            saxParserFactory.setNamespaceAware(true);
            SAXParser saxParser = saxParserFactory.newSAXParser();
            
            File file = new File(Paths.get("src", "docs", "personas_ns.xml").toString());
            
            PersonaHandlerB handler = new PersonaHandlerB();
            saxParser.parse(file, handler);
            
            ArrayList<Persona> persona_ns = handler.getPersona_ns();
            ArrayList<Persona> persona_ns_activa = handler.getPersona_ns_activa();
            
            for (Persona v : persona_ns){
                System.out.println("Persona NO activa: " + v);
            }
            
            for (Persona v : persona_ns_activa){
                System.out.println("Persona activa: " + v);
            }
            
        } catch (SAXException ex) {
            ex.printStackTrace();
            System.out.println("Ha ocurrido una excepción: " + ex.getMessage());
        }catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            System.out.println("Ha ocurrido una excepción: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        }
    }
    
}
