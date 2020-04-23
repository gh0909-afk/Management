package HairShop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="HairShopManagementSystem_table")
public class HairShopManagementSystem {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long manageId;
    private String stylist;
    private Integer reserveId;
    private String reserveTime;

    @PostPersist
    public void onPostPersist(){
        StylistConfirmed stylistConfirmed = new StylistConfirmed();
        BeanUtils.copyProperties(this, stylistConfirmed);
        stylistConfirmed.publish();

        HrSystem hrSystem = new HrSystem();
        hrSystem.setStylistName(this.stylist);
        // mappings goes here

        //스타일리스트 정보 확인
        HrSystemService hrSystemService = Application.applicationContext.getBean(HrSystemService.class);
        HrSystemService.selectStylist(hrSystem);

    }

    @PostUpdate
    public void onPostUpdate(){
        TimeSelected timeSelected = new TimeSelected();
        BeanUtils.copyProperties(this, timeSelected);
        timeSelected.publish();

    }

    @PostRemove
    public void onPostRemove(){
        TimeCanceled timeCanceled = new TimeCanceled();
        BeanUtils.copyProperties(this, timeCanceled);
        timeCanceled.publish();


    }


    public Long getManageId() {
        return manageId;
    }

    public void setManageId(Long manageId) {
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
