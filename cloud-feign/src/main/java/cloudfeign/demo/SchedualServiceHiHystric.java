package cloudfeign.demo;

import org.springframework.stereotype.Component;

/**
 * @author HHF
 * @Description
 * @create 2020-06-14 上午 11:05
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi  {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
