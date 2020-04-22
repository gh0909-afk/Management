package HairShop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="HairShopManagementSystem_table")
public class HairShopManagementSystem {

    private Integer manageId;
    private String stylist;
    private Integer reserveId;
    private String reserveTime;

    @PostPersist
    public void onPostPersist(){
        TimeSelected timeSelected = new TimeSelected();
        BeanUtils.copyProperties(this, timeSelected);
        timeSelected.publish();


    }

    @PostUpdate
    public void onPostUpdate(){
        StylistConfirmed stylistConfirmed = new StylistConfirmed();
        BeanUtils.copyProperties(this, stylistConfirmed);
        stylistConfirmed.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        HairShop.external.HairShopManagementSystem hairShopManagementSystem = new HairShop.external.HairShopManagementSystem();
        // mappings goes here
        Application.applicationContext.getBean(HairShop.external.HairShopManagementSystemService.class)
            .stylistSelection(hairShopManagementSystem);


    }

    @PostRemove
    public void onPostRemove(){
        TimeCanceled timeCanceled = new TimeCanceled();
        BeanUtils.copyProperties(this, timeCanceled);
        timeCanceled.publish();


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
    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }




}
