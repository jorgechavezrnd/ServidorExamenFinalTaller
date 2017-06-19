package com.balance.controller;

import com.balance.model.EscalaresHistory;
import com.balance.model.User;
import com.balance.service.EscalaresHistoryService;
import com.balance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EscalaresHistoryController {
    private EscalaresHistoryService escalaresHistoryService;
    private UserService userService;

    @Autowired
    public void setEscalaresHistoryService(EscalaresHistoryService escalaresHistoryService) {
        this.escalaresHistoryService = escalaresHistoryService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/getEscalares", method = RequestMethod.GET)
    public String getEscalares(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        Integer subidas = 0;
        Integer bajadas = 0;

        Iterable<EscalaresHistory> escalaresHistories = escalaresHistoryService.listAllEscalaresHistorys();
        String aux = "subida";

        for (EscalaresHistory e : escalaresHistories) {
            if (e.getId().equals(user.getId())) {
                if (e.getFecha_registro().equals(new Date())) {
                    if (e.getTipo().equals(aux)) {
                        subidas += e.getCantidad();
                    } else {
                        bajadas += e.getCantidad();
                    }
                }
            }
        }

        model.addAttribute("subidas", subidas);
        model.addAttribute("bajadas", bajadas);

        return "limited/escalares";

    }

    @RequestMapping(value = "/user/getEscalaresHistory", method = RequestMethod.GET)
    public String getEscalaresHistory(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        Iterable<EscalaresHistory> escalaresHistories = escalaresHistoryService.listAllEscalaresHistorys();
        List<EscalaresHistory> escalaresHistoryList = new ArrayList<>();

        for (EscalaresHistory e : escalaresHistories) {
            if (e.getId().equals(user.getId())) {
                escalaresHistoryList.add(e);
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("escalaresList", escalaresHistoryList);

        return "limited/escalaresHistory";
    }
}
