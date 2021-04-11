package Clients;

public enum Priority {
    A(Names.A), B(Names.B), C(Names.C), D(Names.D), E(Names.E);



    public class Names{
        public static final String A = "A";
        public static final String B = "B";
        public static final String C = "C";
        public static final String D = "D";
        public static final String E = "E";

    }
    private final String label;

    private Priority(String label) {
        this.label = label;
    }

    public String toString() {
        return this.label;
    }
}
