package BoEBlockchain;

public class CitizenAges {
    public enum Ages {

        Citizen1("Age0"),
        Citizen2("Age0"),
        Citizen3("Age18"),
        Citizen4("Age21"),
        Citizen5("Age22"),
        Citizen6("Age25"),
        Citizen7("Age28"),
        Citizen8("Age35"),
        Citizen9("Age50"),
        Citizen10("Age100");

        public String id;

        Ages(String id) {
            this.id = id;
        }
    }
}
