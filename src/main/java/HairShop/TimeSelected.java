package HairShop;

public class TimeSelected extends AbstractEvent {

    private Long id;
    private Integer manageId;
    private String stylist;
    private Integer reserveId;
    private String reserveTie;

    public TimeSelected(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getManageId() {
        return manageId;
    }

    public void setManageId(Integer manageId) {
        this.manageId = manageId;
    }
    public String getStylist() {
        return stylist;
    }

    public void setStylist(String stylist) {
        this.stylist = stylist;
    }
    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }
    public String getReserveTie() {
        return reserveTie;
    }

    public void setReserveTie(String reserveTie) {
        this.reserveTie = reserveTie;
    }
}
