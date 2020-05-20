import java.io.*;

import marytts.modules.synthesis.Voice;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import tts.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.parsers.*;


public class translateSpeakText {

    public static void main(String[] args) {
        System.out.print("Enter text to translate: ");
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        String text = "";
        try {
            text = bufRead.readLine();
        } catch (Exception e) {
            System.out.println("Failed to read input.");
            return;
        }

        System.out.print("Enter language code of inputted text: ");
        String lang = "";
        try {
            lang = bufRead.readLine();
        } catch (Exception e) {
            System.out.println("Failed to read input.");
            return;
        }

        String translated = "";
        try {
            System.out.println("\nPlease wait... translating...");
            translated = translateText(text, lang);
        } catch(Exception e) {
            translated = "An error occurred in translation. Look at console for details.";
            System.out.println(e.toString());
        }

        System.out.println("Translation : " + translated);
        System.out.println("Powered by Yandex.Translate");
        System.out.println("\nPlease wait... Outputting speech..");
        TextToSpeech textToSpeech = new TextToSpeech();
        // print out all possible voices:
        // Voice.getAvailableVoices().stream().forEach(System.out::println);

        textToSpeech.setVoice("dfki-poppy-hsmm"); // female voice

        textToSpeech.speak(translated, 1.5f, false, true);

    }

    private static String translateText(String text, String lang) throws MalformedURLException, IOException, ProtocolException, ParserConfigurationException, SAXException {
        String url = "https://translate.yandex.net/api/v1.5/tr/translate?key=trnsl.1.1.20200519T200302Z.d34cc59f3f11cfaf." +
                "f3ab7d2fe09da37afa4dc92ea3c42c3551a5a244&text=" + text + "&lang="+ lang + "-en&format=plain&options=1";

        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
        httpClient.setRequestMethod("GET");

        //int responseCode = httpClient.getResponseCode();
        //System.out.println("Response Code : " + responseCode);
        InputStreamReader in = new InputStreamReader(httpClient.getInputStream());
        BufferedReader bufRead = new BufferedReader(in);

        StringBuilder xmlResponse = new StringBuilder();
        String line;
        while ((line = bufRead.readLine()) != null) {
            xmlResponse.append(line);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlResponse.toString()));
        Document doc =  builder.parse(is);

        NodeList nodeList = doc.getElementsByTagName("Translation");
        Element element = (Element) nodeList.item(0);

        NodeList textNodes = element.getElementsByTagName("text");
        Element translation = (Element) textNodes.item(0);

        Node textData = translation.getFirstChild();
        return ((CharacterData)textData).getData();

    }
}
