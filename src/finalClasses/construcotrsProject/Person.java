package finalClasses.construcotrsProject;

public record Person(String name, String dob) {

//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace("-","/");
//    }

    public Person(Person p) {
        this(p.name, p.dob);
    }

    public Person { //gets insert into canonical constructor
        if (dob == null) throw new IllegalArgumentException("Bad data");
        dob = dob.replace("-", "/");
    }
}
