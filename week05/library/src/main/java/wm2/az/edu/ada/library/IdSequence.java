package wm2.az.edu.ada.library;

public class IdSequence {
    private static Integer id = 0;
    public static Integer next(){
        return ++id;
    }
}
