package HairShop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(name ="hrSystems", url="http://localhost:8084")
public interface HrSystemService {

    @RequestMapping(method = RequestMethod.POST, value = "/paymentSystems", consumes = "application/json")
    void selectStylist(HrSystem hrSystem);

}
