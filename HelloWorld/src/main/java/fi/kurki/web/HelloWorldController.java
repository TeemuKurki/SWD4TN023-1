package fi.kurki.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorldController {
	
	@RequestMapping("*")
	public String helloWorld(){
		return "HelloWörld";
	}

}
