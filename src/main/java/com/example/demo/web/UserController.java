package com.example.demo.web;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Integer id){
        return  userService.getUser(id).toString();
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String addUser(@RequestParam("name")String name,
                          @RequestParam("sex")String sex,
                          @RequestParam("phone")String phone,
                          @RequestParam("password")String password){
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setPassword(password);
        user.setPhone(phone);
        int result = userService.addUser(user);
        return "success:"+result;
    }
}
