package psr.debesson.novel.domain;

public class Premise {

    private String character;

    private String situation;

    private String objective;

    private String opponent;

    private String disaster;

    private String fullPremise;

    public Premise() {
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getDisaster() {
        return disaster;
    }

    public void setDisaster(String disaster) {
        this.disaster = disaster;
    }

    public String getFullPremise() {
        return fullPremise;
    }

    public void setFullPremise(String fullPremise) {
        this.fullPremise = fullPremise;
    }

    @Override
    public String toString() {
        return "Premise{" +
                "character='" + character + '\'' +
                ", situation='" + situation + '\'' +
                ", objective='" + objective + '\'' +
                ", opponent='" + opponent + '\'' +
                ", disaster='" + disaster + '\'' +
                ", fullPremise='" + fullPremise + '\'' +
                '}';
    }
}
