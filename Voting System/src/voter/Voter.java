package voter;

import java.util.Iterator;

public class Voter {
    private String votername;
    private int voter_id;
    public Voter(int v_id,String v_name ){
        this.votername=v_name;
        this.voter_id=v_id;
    }
    public int getVoter_id() {
        return voter_id;
    }

    public String getVotername() {
        return votername;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "votername='" + votername + '\'' +
                ", voter_id=" + voter_id +
                '}';
    }
}
