package com.springmvc;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class ParamController {


    @RequestMapping(value = "/sayhello", method = RequestMethod.POST)
    public String sayHello(@RequestParam(type = Person.class) Person person) {
        return "hello, i am " + person.getName() + ", i am " + person.getAge();
    }


    @RequestMapping(value = "/test")
    public String test(@RequestParam(type = Integer.class, name = "id", contentType = ContentTypeEnum.FORMDATA) Integer id,
                       @RequestParam(type = String.class, name = "name1", contentType = ContentTypeEnum.FORMDATA) String name,
                       Person person) {
        return id + name + person;
    }
}
