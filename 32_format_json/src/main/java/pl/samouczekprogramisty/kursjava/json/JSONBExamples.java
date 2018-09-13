package pl.samouczekprogramisty.kursjava.json;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;

public class JSONBExamples {
    private static final Newspaper newspaper = new Newspaper("Samouczek Programisty", 100_000, LocalDate.of(2018, 9, 13));

    private static final Jsonb jsonb = JsonbBuilder.create();

    public static void main(String[] args) {
        objectWriting();
        objectReading();
        annotationsWriting();
    }

    private static void annotationsWriting() {
        AnnotationExamples annotationExamples = new AnnotationExamples();
        annotationExamples.setBbb(123.45);
        annotationExamples.setCcc("ccc");
        annotationExamples.setSkipped("skipped");

        WithoutAnnotationExamples withoutAnnotationExamples = new WithoutAnnotationExamples();
        withoutAnnotationExamples.setBbb(123.45);
        withoutAnnotationExamples.setCcc("ccc");
        withoutAnnotationExamples.setSkipped("skipped");

        System.out.println(jsonb.toJson(annotationExamples));
        System.out.println(jsonb.toJson(withoutAnnotationExamples));
    }

    private static void objectWriting() {
        String newspaperRepresentation = jsonb.toJson(newspaper);
        System.out.println(newspaperRepresentation);
    }

    private static void objectReading() {
        String newspaperRepresentation = jsonb.toJson(newspaper);

        Newspaper otherNewspaper = jsonb.fromJson(newspaperRepresentation, Newspaper.class);
        System.out.println(otherNewspaper.getIssueDate());
    }
}
