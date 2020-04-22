package HairShop;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ReservationStatus_table")
public class ReservationStatus {

        private String stylistId;
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer viewId;
        private String time;
        private Integer viewReverveId;


        public String getStylistId() {
            return stylistId;
        }

        public void setStylistId(String stylistId) {
            this.stylistId = stylistId;
        }
        public Integer getViewId() {
            return viewId;
        }

        public void setViewId(Integer viewId) {
            this.viewId = viewId;
        }
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
        public Integer getViewReverveId() {
            return viewReverveId;
        }

        public void setViewReverveId(Integer viewReverveId) {
            this.viewReverveId = viewReverveId;
        }

}
