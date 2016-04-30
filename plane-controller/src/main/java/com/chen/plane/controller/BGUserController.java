package com.chen.plane.controller;

import com.chen.plane.domain.pojo.BGUser;
import com.chen.plane.service.BGUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.modelmbean.ModelMBean;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * </p>Copyright(c)	Devlopment Dept/XiaoFang All Rights Reserved</p>
 *
 * @author ouyangzhao(ouyangzhao@66xf.com)
 * @version 1.0  2016/4/30
 */
@Controller
@RequestMapping(value = "/plane/bg")
public class BGUserController {
	private static final Logger log = Logger.getLogger(BGUserController.class);
	@Autowired
	private BGUserService bgUserService;

	/**
	 * 增加后台用户
	 * @param bgUser
	 * @return
	 */
	@RequestMapping(value = "/addBGUser.do",method = RequestMethod.POST)
	public String addBGUser(BGUser bgUser){
		log.debug("BGUserController.addBGUser>>>");
		try{
			bgUserService.addBGUser(bgUser);
			return "/admin/adminLogin";
		}catch (Exception e){
			e.printStackTrace();
			return "/admin/registerAdmin";
		}
	}

	/**
	 * 后台普通管理员列表
	 * @param
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/updateBGUserIndex.do",method = RequestMethod.GET)
	public String updateBGUserIndex(ModelMap modelMap){
		log.debug("BGUserController.updateBGUserIndex>>>");
		List<BGUser> bgUserList = bgUserService.getAllBGUser();
		modelMap.addAttribute("adminList", bgUserList);
		log.debug("BGUserController.updateBGUserIndex<<<");
		return "/admin/bgUserList";
	}

	/**
	 * 获得要修改后台用户信息
	 * @return
	 */
	@RequestMapping(value = "/updateBgUserInfo.do",method = RequestMethod.GET)
	public String updateBgUserInfo(BGUser bgUser,HttpSession session,ModelMap modelMap){
		log.debug("BGUserController.updateBgUserInfo>>>");
		BGUser bgUser1 = (BGUser) session.getAttribute("admin");
		if (bgUser1 != null && bgUser1.getBGRole().equals("ADMIN")){
			BGUser bgUser2 = bgUserService.getBGUser(bgUser);
			modelMap.addAttribute("admin",bgUser2);
			log.debug("BGUserController.updateBGUser<<<");
			return "/admin/updateAdmin";
		}else {
			return "/admin/noRole";
		}
	}

	/**
	 * 更新后台管理员信息
	 * @param bgUser
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/updateBGUser.do",method = RequestMethod.POST)
	public String updateBGUser(BGUser bgUser,ModelMap modelMap,HttpSession session){
		log.debug("BGUserController.updateBGUser>>>");
		log.debug("BGUser:" + bgUser);
		BGUser bgUser1 = (BGUser) session.getAttribute("admin");
		if (bgUser1 != null && bgUser1.getBGRole().equals("ADMIN")){
			bgUserService.updateBGUser(bgUser);
			modelMap.addAttribute("adminList",bgUserService.getAllBGUser());
			log.debug("BGUserController.updateBGUser<<<");
			return "/admin/bgUserList";
		}else {
			return "/admin/noRole";
		}

	}

	/**
	 * 删除管理员
	 * @param BGId
	 * @param session
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/deleteBGUser.do",method = RequestMethod.GET)
	public String deleteBGUser(Integer BGId,HttpSession session,ModelMap modelMap){
		log.debug("BGUserController.deleteBGUser>>>");
		BGUser bgUser1 = (BGUser) session.getAttribute("admin");
		if (bgUser1 != null && bgUser1.getBGRole().equals("ADMIN")){
			bgUserService.deleteBGUser(BGId);
			modelMap.addAttribute("adminList",bgUserService.getAllBGUser());
			log.debug("BGUserController.updateBGUser<<<");
			return "/admin/bgUserList";
		}else {
			return "/admin/noRole";
		}
	}

	/**
	 * 增加后台用户首页
	 * @return
	 */
	@RequestMapping(value = "/addBGUserIndex.do",method = RequestMethod.GET)
	public String addBGUserIndex(){
		log.debug("BGUserController.addBGUserIndex>>>");
		log.debug("BGUserController.addBGUserIndex<<<");
		return "/admin/registerAdmin";
	}

	/**
	 * 获得后台用户信息
	 * @return
	 */
	@RequestMapping(value = "/getBGUserInfo.do",method = RequestMethod.GET)
	@ResponseBody
	public String getBGUserInfo(BGUser bgUser){
		log.debug("BGUserController.getBGUserInfo>>>");
		BGUser bgUser1 = bgUserService.getBGUser(bgUser);
		if (bgUser1 != null){
			return "exist";
		}
		log.debug("BGUserController.getBGUserInfo<<<");
		return null;
	}
}
