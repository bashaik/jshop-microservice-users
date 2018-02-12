
package com.jshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jshop.core.logging.JShopLogger;
import com.jshop.service.IRemoteUserService;
import com.jshop.service.IUserService;
import com.jshop.service.JShopServiceException;
import com.jshop.service.LoginRequest;
import com.jshop.service.LoginResponse;
import com.jshop.shared.rest.BaseController;
import com.jshop.shared.rest.JShopControllerException;

@RestController
@RequestMapping(IRemoteUserService.USERS_URL)
public class UsersController extends BaseController implements IRemoteUserService
{
    private static final JShopLogger LOGGER = new JShopLogger(UsersController.class);

    @Autowired
    private IUserService userService;
    
    @Override
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest)
    {
    		try {
    			return userService.login(loginRequest);
    		} 
        catch (JShopServiceException serviceExcp)
        {
            LOGGER.error("Exception on authentication ", serviceExcp);
            throw new JShopControllerException("Login failed", HttpStatus.UNAUTHORIZED);
        }
    }

}
