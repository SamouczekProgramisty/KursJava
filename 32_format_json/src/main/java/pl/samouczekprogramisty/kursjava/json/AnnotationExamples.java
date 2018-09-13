package pl.samouczekprogramisty.kursjava.json;

import javax.json.bind.annotation.JsonbNumberFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder({"ccc", "bbb", "aaa"})
public class AnnotationExamples {
    @JsonbTransient
    private String skipped;

    @JsonbProperty(nillable=true)
    private String a1;

    private String a2;

    @JsonbNumberFormat("0.0000")
    private double bbb;

    @JsonbProperty("other_name")
    private String ccc;

    public String getSkipped() {
        return skipped;
    }

    public void setSkipped(String skipped) {
        this.skipped = skipped;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public double getBbb() {
        return bbb;
    }

    public void setBbb(double bbb) {
        this.bbb = bbb;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }
}
