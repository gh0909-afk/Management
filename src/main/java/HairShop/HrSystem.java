package HairShop;

import javax.persistence.*;

@Entity
@Table(name="HrSystem_table")
public class HrSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer stylistId;
    private String stylistName;


    public Integer getStylistId() {
        return stylistId;
    }

    public void setStylistId(Integer stylistId) {
        this.stylistId = stylistId;
    }
    public String getStylistName() {
        return stylistName;
    }

    public void setStylistName(String stylistName) {
        this.stylistName = stylistName;
    }




}
