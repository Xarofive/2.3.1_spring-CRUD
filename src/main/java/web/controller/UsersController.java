package web.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.DAO.UserDAO;


@Controller
//@RequestMapping("/")
public class UsersController {

    private UserDAO userDAO;

    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users",userDAO.index());
        return "users";
    }


}
