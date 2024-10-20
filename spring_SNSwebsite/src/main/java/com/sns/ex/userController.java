package com.sns.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sns.dto.UserDto;
import com.sns.service.IUserService;

@Controller
@RequestMapping("/user")
public class userController {
	private static final Logger logger = LoggerFactory.getLogger(userController.class);
	@Autowired
	private IUserService service;
	
	@RequestMapping(value="createUser",method=RequestMethod.POST)
	public String createUser(UserDto dto,RedirectAttributes rttr) throws Exception{
		logger.info("createUser"+dto);
		service.createUser(dto);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/main/home";
	}
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public void main(Model model)throws Exception{
		
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public void update(Model model)throws Exception{
		
	}
//	@RequestMapping(value="/updateDB",method=RequestMethod.GET)
//	public String updateDB (UserDto dto)throws Exception{
//		service.updateUser(dto);
//		return "redirect:/user/main";
//	}
	
}
