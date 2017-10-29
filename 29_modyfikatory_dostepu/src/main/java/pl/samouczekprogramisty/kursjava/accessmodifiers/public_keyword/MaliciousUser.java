package pl.samouczekprogramisty.kursjava.accessmodifiers.public_keyword;

public class MaliciousUser {

    public void countMyVisit(PublicVisitCounter counter) {
        counter.increment();
        counter.userCount = -10;
    }

}
