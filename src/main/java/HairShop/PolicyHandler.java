package HairShop;

import HairShop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    HairShopManagementSystemRepository hairShopManagementSystemRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_예약취소(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### listener 예약취소 : " + reservationCanceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_예약받음(@Payload Reserved reserved){

        System.out.println("여기 들어오나?");

        if(reserved.isMe()){
            System.out.println("##### listener 예약 : " + reserved.toJson());
            // 스타일리스트 존재 하는지 확인
            HrSystemService hrSystemService = Application.applicationContext.getBean(HrSystemService.class);
            HrSystem hrSystem = new HrSystem();
            hrSystem.setStylistName(reserved.getStylist());
            hrSystemService.selectStylist(hrSystem);

            // 호출 기다렸다가 예약 저장
            HairShopManagementSystem hairShopManagementSystem = new HairShopManagementSystem();
            hairShopManagementSystem.setReserveId(reserved.getReserveId());
            hairShopManagementSystem.setReserveTime(reserved.getTime());
            hairShopManagementSystem.setStylist(reserved.getStylist());

            hairShopManagementSystemRepository.save(hairShopManagementSystem);

        }
    }


}
