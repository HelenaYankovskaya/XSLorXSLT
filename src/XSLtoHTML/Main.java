package XSLtoHTML;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class Main {     // Задание №12 РТ-2 стр 39

    public static void main(String[] args) {

        try {
            File inputFile = new File("C:\\Users\\user\\IdeaProjects\\untitled\\src\\InfoForXSL");
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Builder = null;
            try {
                Builder = Factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            Document doc = Builder.parse(inputFile);


            File stylesheet = new File("C:\\Users\\user\\IdeaProjects\\untitled\\src\\TransformFileXLS");
            StreamSource styleSourse = new StreamSource(stylesheet);
        Transformer t = null;
        try {
            t = TransformerFactory.newInstance().newTransformer(styleSourse);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        t.transform(new DOMSource(doc.getDocumentElement()), new StreamResult("C:\\Users\\user\\IdeaProjects\\untitled\\src\\NEWXSLFile.txt"));

        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }}

