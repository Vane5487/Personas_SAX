/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.edu.teis.sax.handler;

import es.edu.teis.sax.model.Persona;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author a20vanesagp
 */
public class PersonaHandlerB extends DefaultHandler {
    private static final String PERSONA_TAG = "persona";
    private static final String PERSONA_TAG2 = "personas";
    private static final String PERSONA_ATT_ID = "id";
    private static final String PERSONA_NOMBRE_TAG = "nombre";
    private static final String PERSONA_DNI_TAG = "dni";
    private static final String PERSONA_EDAD_TAG = "edad";
    private static final String PERSONA_SALARIO_TAG = "salario";
    private static final String PERSONA_ATT_BORRADO = "borrado";
    
    private static final String PERSONA_URI = "http://www.personas.com";
    private static final String PERSONA_URI_ACTIVA = "http://www.personas.com/active";
    
    
    private ArrayList<Persona> personas_ns = new ArrayList();
    private ArrayList<Persona> personas_ns_activa = new ArrayList();
    private Persona persona;
    private StringBuilder buffer = new StringBuilder();

    
    public ArrayList<Persona> getPersona_ns() {
        return personas_ns;
    }
    
    public ArrayList<Persona> getPersona_ns_activa() {
        return personas_ns_activa;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.delete(0, buffer.length());
        buffer.append(ch, start, length);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (localName) {
            case PERSONA_NOMBRE_TAG:
                persona.setNombre(buffer.toString());
                break;
            case PERSONA_DNI_TAG:
                persona.setDni(buffer.toString());
                break;
            case PERSONA_EDAD_TAG:
                persona.setEdad(Integer.parseInt(buffer.toString()));
                break;
            case PERSONA_SALARIO_TAG:
                persona.setSalario(Float.parseFloat(buffer.toString()));
                break;
            case PERSONA_TAG:
                if(PERSONA_URI.equals(uri)){
                    personas_ns.add(persona);
                } else if(PERSONA_URI_ACTIVA.equals(uri)) {
                    personas_ns_activa.add(persona);
                }
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (localName) {

            case PERSONA_TAG:
                persona = new Persona();
                persona.setId(Long.parseLong(attributes.getValue(PERSONA_ATT_ID)));
                persona.setBorrado(Boolean.parseBoolean(attributes.getValue(PERSONA_ATT_BORRADO)));
                break;
            case PERSONA_TAG2:
                System.out.println("Personas found");
                break;

        }
    }
}
