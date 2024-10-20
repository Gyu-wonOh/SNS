package com.sns.ex;

import javax.servlet.http.HttpSession;

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
@RequestMapping("/main")
public class loginController {
	private static final Logger logger = LoggerFactory.getLogger(loginController.class);
	@Autowired
	private IUserService service;
	@RequestMapping(value ="/home", method=RequestMethod.GET)
	public void home(Model model)throws Exception{
		
	}
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void join(Model model)throws Exception{
		
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserDto dto, HttpSession session, RedirectAttributes rttr) throws Exception{
		String nickname = dto.getNickname();
		String password = dto.getPassword();
		if(nickname!=null & password!=null) {
			UserDto userLog = service.selectUser(nickname);
			if(userLog!=null&&nickname.equals(userLog.getNickname())&&password.equals(userLog.getPassword())) {
				session.setAttribute("user", nickname);
				return "redirect:/common/main";
			}
		}
		rttr.addFlashAttribute("msg","fail");
		return "redirect:/main/home";
	}
}
