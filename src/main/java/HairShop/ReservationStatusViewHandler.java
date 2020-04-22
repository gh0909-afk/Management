package HairShop;

import HairShop.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationStatusViewHandler {


    @Autowired
    private ReservationStatusRepository reservationStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTimeSelected_then_CREATE_1 (@Payload TimeSelected timeSelected) {
        try {
            if (timeSelected.isMe()) {
                // view 객체 생성
                ReservationStatus reservationStatus = new ReservationStatus();
                // view 객체에 이벤트의 Value 를 set 함
                reservationStatus.setStylistId(timeSelected.getStylist());
                reservationStatus.setTime(timeSelected.getReserveTie());
                reservationStatus.setViewReverveId(timeSelected.getReserveId());
                // view 레파지 토리에 save
                reservationStatusRepository.save(reservationStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_DELETE_1(@Payload ReservationCanceled reservationCanceled) {
        try {
            if (reservationCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                //reservationStatusRepository.deleteById(reservationCanceled.getReserveId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}