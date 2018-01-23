package com.contactapp.controller;

import com.contactapp.binding.UserBinding;
import com.contactapp.domain.User;
import com.contactapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by gazi_muhib on 8/3/17.
 */

@Controller
public class UsersController {
    @Autowired
    private UserService userService;


    @RequestMapping({"/","/login"})
    public String login_controller(){
        return "login";
    }


    @RequestMapping("/dashboard")
    public String home_controller(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){

        User user=user=userService.login(username,password);


        if(user !=null ){
            if(user.getRole().equals(UserService.ROLE_USER)){

                //i have to bind in session object
                bindUserInSession(user,session);
                return "redirect:user/dashboard";
            }
            else
            {
                bindUserInSession(user,session);
                return "redirect:admin/dashboard";
            }
        }
        return  "login";
    }

    @RequestMapping("/register")

    public String register(@ModelAttribute("userinfo") UserBinding ub){

        try{
            User user=ub.getUser();
            user.setRole(UserService.ROLE_USER);
            user.setLogin_status(UserService.ACTIVE);
            userService.register(user);
            return "redirect:login?res=success";
        }
        catch (DuplicateKeyException e)
        {
            e.printStackTrace();
        }
        return "redirect:registration-form?acc=error";
    }


    @RequestMapping(value = "/registration-form")
    public String registrationForm(Model model){

        model.addAttribute("userinfo",new UserBinding());

       return "reg_form";
    }

    @RequestMapping("/user/dashboard")
    public String userDashborad(){
        return "user_dashboard";
    }

    @RequestMapping("/admin/dashboard")
    public String adminDashborad(){
        return "admin_dashboard";
    }

    @RequestMapping("/logout")
    public String logoutUser(HttpSession session){
        session.invalidate();
        return "redirect:login?res2=logout";
    }


    private void bindUserInSession(User u,HttpSession session){
        session.setAttribute("logedUser",u);
        session.setAttribute("userId",u.getUser_id());
        session.setAttribute("role",u.getRole());
        session.setAttribute("username",u.getLogin_name());
    }
}
