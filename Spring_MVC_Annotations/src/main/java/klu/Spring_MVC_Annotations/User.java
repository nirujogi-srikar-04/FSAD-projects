package klu.Spring_MVC_Annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class User {
	@GetMapping("/d2")
	@ResponseBody
	public String display() {
 return "Welcome controller";
}
	@GetMapping("/d1")
	@ResponseBody
	public String display1() {
 return "Welcome controller 3";
}
}
