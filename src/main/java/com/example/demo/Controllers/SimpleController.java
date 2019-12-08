package com.example.demo.Controllers;

import com.example.demo.NHSLogin.NHSLoginClient;
import com.example.demo.dto.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController {

    private com.example.demo.NHSLogin.NHSLoginClient NHSLoginClient;

    SimpleController(NHSLoginClient NHSLoginClient) {
        this.NHSLoginClient = NHSLoginClient;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code, Model model) {

        String accessToken = NHSLoginClient.getAccessToken(code);
        UserInfo userInfo = NHSLoginClient.getUserInfo(accessToken);

        model.addAttribute("user", userInfo);

        return "userinfo";
    }
}
