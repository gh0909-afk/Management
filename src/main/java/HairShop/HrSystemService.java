package HairShop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(name ="hrSystems", url="http://52.231.118.11:8080")
public interface HrSystemService {

    @RequestMapping(method = RequestMethod.POST, value = "/hrSystems", consumes = "application/json")
    static void selectStylist(HrSystem hrSystem) {
        System.out.print("스타일리스트 시간 확인");
    }

}
