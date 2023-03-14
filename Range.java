package Task1;

public class Range {
    private final int start;
    private final int end;

    public int getStart() {
        return start;
    }

    public Range(int start, int end) {
        if (start > end) {
            System.out.println("Start cannot be more then end!");
        }

        this.start = start;
        this.end = end;
    }

    public int getLength() {
        return end - start + 1;
    }
}
