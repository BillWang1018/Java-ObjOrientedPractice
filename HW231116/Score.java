package HW231116;

public class Score implements Comparable<Score> {

    private int total;
    private int chinese;
    private int english;
    private int math;

    public Score(int chinese, int english, int math) {
        this.total = chinese + english + math;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Score sc) {
        if(total != sc.total) {
            return sc.total - total;
        } else { // (total == sc.total) 
            if(chinese != sc.chinese) {
                return sc.chinese - chinese;
            } else { // (chinese == sc.chinese)
                if(english != sc.english) {
                    return sc.english - english;
                } else { // (english == sc.english)
                    return sc.math - math;
                }
            }
        }
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getChinese() {
        return chinese;
    }
    public void setChinese(int chinese) {
        this.chinese = chinese;
    }
    public int getEnglish() {
        return english;
    }
    public void setEnglish(int english) {
        this.english = english;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    
}
