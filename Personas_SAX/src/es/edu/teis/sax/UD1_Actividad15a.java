package es.edu.teis.sax;

import es.edu.teis.sax.handler.PersonaHandlerA;
import es.edu.teis.sax.handler.PersonaHandlerB;
import es.edu.teis.sax.model.Persona;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author a20vanesagp
 */
public class UD1_Actividad15a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            //saxParserFactory.setNamespaceAware(true);
            SAXParser saxParser;
            saxParser = saxParserFactory.newSAXParser();
            
            File file = new File(Paths.get("src", "docs", "personas.xml").toString());
            
            PersonaHandlerA handler = new PersonaHandlerA();
            saxParser.parse(file, handler);
            
            ArrayList<Persona> persona = handler.getPersona();
            
            for (Persona v : persona){
                System.out.println(v);
            }
            
        } catch (SAXException ex) {
            ex.printStackTrace();
            System.out.println("Ha ocurrido una excepción: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Ha ocurrido una excepción: " + ex.getMessage());
        }catch (ParserConfigurationException ex) {
            ex.printStackTrace();
            System.out.println("Ha ocurrido una excepción: " + ex.getMessage());
        }
    }
    
}
