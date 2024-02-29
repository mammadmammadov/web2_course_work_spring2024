package wm2.az.edu.ada.library;

public class BookIdSequence {
    private static Integer value = -1;

    public static Integer next() {
        return ++value;
    }
}
