package nominee;

public class Nominee_details {
    private String nomineename;
    private int nominee_id;
    public Nominee_details(int n_id,String n_name ){
        this.nomineename=n_name;
        this.nominee_id=n_id;
    }

    public int getNominee_id() {
        return nominee_id;
    }

    public String getNomineename() {
        return nomineename;
    }
}

