package LogBook.Week3and4;

public enum Grades
{

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    INVALID_MARK("invalid mark");

    final String string_value;

    Grades (String string_value)
    {this.string_value = string_value;}
}
