package com.columbusstate.airline.controller;

import com.columbusstate.airline.model.ReservationSession;
import com.columbusstate.airline.model.Search;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainContoller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("search", new Search());

        request.getSession().setAttribute("reservationSession", new ReservationSession());

        return modelAndView;

    }
}
