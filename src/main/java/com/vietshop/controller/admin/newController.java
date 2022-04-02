package com.vietshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "newControllerOfAdmin")
public class newController {
  
   @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
   public ModelAndView showList() {
      ModelAndView mav = new ModelAndView("admin/new/list");
      return mav;
   }
   
   @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
   public ModelAndView editNew() {
      ModelAndView mav = new ModelAndView("admin/new/edit");
      return mav;
   }
  
   
}