package com.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

/*
    private static Logger logger = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        logger.info(user.toString());
        return user;
    }
*/

/*
    @GetMapping(value = "/users")
    @ResponseBody
    public Result getAllUsers(@RequestParam Integer page, @RequestParam Integer limit) {
        List<User> users = userService.findAllUsers(page,limit);
        Result result = ResultUtil.getResult(RspEnum.SUCCESSFUL, users, users.size());
        return result;
    }
*/

}
