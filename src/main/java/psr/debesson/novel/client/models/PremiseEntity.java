package psr.debesson.novel.client.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PremiseEntity {

    @Column(name = "premise_character")
    private String character;

    @Column(name = "premise_situation")
    private String situation;

    @Column(name = "premise_objective")
    private String objective;

    @Column(name = "premise_opponent")
    private String opponent;

    @Column(name = "premise_disaster")
    private String disaster;

    @Column(name = "premise")
    private String fullPremise;

    public PremiseEntity() {
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
        return "PremiseEntity{" +
                "character='" + character + '\'' +
                ", situation='" + situation + '\'' +
                ", objective='" + objective + '\'' +
                ", opponent='" + opponent + '\'' +
                ", disaster='" + disaster + '\'' +
                ", fullPremise='" + fullPremise + '\'' +
                '}';
    }
}
