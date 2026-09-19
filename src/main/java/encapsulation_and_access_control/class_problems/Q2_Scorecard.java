package encapsulation_and_access_control.class_problems;

class Scorecard {
    private final boolean[] results;
    private final int totalQuestions;
    private int recorded;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
    }

    void recordAnswer(boolean correct) {
        if (recorded < totalQuestions) {
            results[recorded] = correct;
            recorded++;
        }
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
