package jp.co.internous.wasabi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.wasabi.model.domain.TblCart;
import jp.co.internous.wasabi.model.domain.dto.CartDto;
import jp.co.internous.wasabi.model.form.CartForm;
import jp.co.internous.wasabi.model.mapper.TblCartMapper;
import jp.co.internous.wasabi.model.session.LoginSession;

@Controller
@RequestMapping("/wasabi/cart")
public class CartController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private TblCartMapper tblCartMapper;
	
	private Gson gson = new Gson();

	@RequestMapping("/")
	public String cart(Model m) {
		
		int userId = loginSession.getUserId();
		
		if (userId == 0) {
			userId = loginSession.getTempUserId();
		}
		
		List<CartDto> cartDto = tblCartMapper.findByUserId(userId);
		
		m.addAttribute("loginSession", loginSession);
		m.addAttribute("cartDto", cartDto );
		
		return "cart";
	}
	
	@RequestMapping("/add")
	public String addCart(CartForm f, Model m) {
		
		int userId = loginSession.getUserId();
		
		if(userId == 0) {
			userId = loginSession.getTempUserId();
		}
		
		f.setUserId(userId);
		
		TblCart cart = new TblCart(f);
		
		long result = 0;
		
		if(tblCartMapper.findCountByUserIdAndProductId(userId, f.getProductId()) > 0) {
			result = tblCartMapper.update(cart);
		}else {
			result = tblCartMapper.insert(cart);
		}
		if (result > 0) {
			List<CartDto> cartDto = tblCartMapper.findByUserId(userId);
			
			m.addAttribute("loginSession", loginSession);
			m.addAttribute("cartDto", cartDto);
		}
		
		return "cart";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/delete")
	@ResponseBody
	public boolean deleteCart(@RequestBody String checkedIdList) {
		
		int result = 0;
		
		Map<String, List<String>> map = gson.fromJson(checkedIdList, Map.class);
		List<String> checkedIds = map.get("checkedIdList");
		
		result = tblCartMapper.deleteById(checkedIds);
		return result > 0;
	}
}
