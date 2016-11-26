package controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.RecModel;
import service.RecServiceImpl;

@RestController
public class RedisController {

	@Autowired
	RecServiceImpl recSerImpl;

	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Set<String> redisImpliment(@ModelAttribute("recmodel") RecModel rm) {
		System.out.println("Inside redis controller");
		recSerImpl.addVisitor(rm);
		recSerImpl.addToContentMap(rm);
		return recSerImpl.getSuggestion(rm);
	}
}
