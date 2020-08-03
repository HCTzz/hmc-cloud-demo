package com.hmc.commomtest;

//import com.hmc.redis.template.RedisRepository;
import com.hmc.redis.template.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CommomTestApplication {

    @Autowired
    private RedisRepository redisRepository;

    public static void main(String[] args) {
        SpringApplication.run(CommomTestApplication.class, args);
    }

    @GetMapping("/set")
    public void setName(String name){
        redisRepository.set("test" ,name);
    }

    @GetMapping("/get")
    public Object get(){
        return redisRepository.get("test");
    }

    @GetMapping("/delete")
    public void delete(){
        redisRepository.del("test");
    }



}
