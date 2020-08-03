package ribbonservice.cloudribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHF
 * @Description
 * @create 2020-06-12 下午 5:36
 */
@RestController()
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public String test(@RequestParam String name){
        return testService.hiService(name);
    }

}
