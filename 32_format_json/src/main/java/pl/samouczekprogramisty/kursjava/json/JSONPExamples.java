package pl.samouczekprogramisty.kursjava.json;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

public class JSONPExamples {

    public static void main(String[] args) {
        objectModeWriting();
        objectModeReading();
        streamModeWriting();
        streamModeReading();
    }

    private static void streamModeWriting() {
        JsonGeneratorFactory generatorFactory = Json.createGeneratorFactory(Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true));
        JsonGenerator generator = generatorFactory.createGenerator(System.out);
        generator
            .writeStartObject()
                .write("imię", "Marcin")
                .write("nazwisko", "Pietraszek")
                .writeStartObject("strona")
                    .write("adres www", "http://www.samouczekprogramisty.pl")
                    .writeStartArray("artykuły")
                        .writeStartObject()
                            .write("tytuł", "Format JSON w języku Java")
                            .writeStartObject("data publikacji")
                                .write("rok", 2018)
                                .write("miesiąc", 9)
                                .write("dzień", 13)
                            .writeEnd()
                        .writeEnd()
                    .writeEnd()
                .writeEnd()
            .writeEnd().flush();
    }

    private static void streamModeReading() {
        JsonParserFactory parserFactory = Json.createParserFactory(Collections.emptyMap());
        JsonParser parser = parserFactory.createParser(buildObject());

        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch (event) {
                case START_OBJECT:
                    System.out.println("{");
                    break;
                case END_OBJECT:
                    System.out.println("}");
                    break;
                case START_ARRAY:
                    System.out.println("[");
                    break;
                case END_ARRAY:
                    System.out.println("]");
                    break;
                case KEY_NAME:
                    System.out.print(String.format("\"%s\": ", parser.getString()));
                    break;
                case VALUE_NUMBER:
                    System.out.println(parser.getBigDecimal());
                    break;
                case VALUE_STRING:
                    System.out.println(String.format("\"%s\"", parser.getString()));
                    break;
                default:
                    System.out.println("true, false or null");
            }
        }

    }

    private static void objectModeWriting() {
        JsonObject authorObject = buildObject();

        System.out.println(authorObject.toString());
        write(authorObject, System.out);
    }

    private static void write(JsonObject jsonObject, OutputStream outputStream) {
        Map<String, ?> config = Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory writerFactory = Json.createWriterFactory(config);
        writerFactory.createWriter(outputStream).write(jsonObject);
    }

    private static void objectModeReading() {
        String jsonDocument = buildObject().toString();

        JsonReaderFactory readerFactory = Json.createReaderFactory(Collections.emptyMap());
        try (JsonReader jsonReader = readerFactory.createReader(new ByteArrayInputStream(jsonDocument.getBytes()))) {
            JsonStructure jsonStructure = jsonReader.read();
            System.out.println(jsonStructure.getValue("/strona/artykuły/0/data publikacji"));
        }

        try (JsonReader jsonReader = readerFactory.createReader(new ByteArrayInputStream(jsonDocument.getBytes()))) {
            JsonObject jsonObject = jsonReader.readObject();
            System.out.println(jsonObject
                            .getJsonObject("strona")
                            .getJsonArray("artykuły")
                            .get(0).asJsonObject()
                            .getJsonObject("data publikacji")
            );
        }
    }

    private static JsonObject buildObject() {
        JsonBuilderFactory builderFactory = Json.createBuilderFactory(Collections.emptyMap());
        JsonObject publicationDateObject = builderFactory.createObjectBuilder()
                .add("rok", 2018)
                .add("miesiąc", 9)
                .add("dzień", 13).build();

        JsonObject articleObject = builderFactory.createObjectBuilder()
                .add("tytuł", "Format JSON w języku Java")
                .add("data publikacji", publicationDateObject).build();

        JsonArray articlesArray = builderFactory.createArrayBuilder().add(articleObject).build();

        JsonObject webPageObject = builderFactory.createObjectBuilder()
                .add("adres www", "http://www.samouczekprogramisty.pl")
                .add("artykuły", articlesArray).build();

        return builderFactory.createObjectBuilder()
                .add("imię", "Marcin")
                .add("nazwisko", "Pietraszek")
                .add("strona", webPageObject).build();
    }
}
