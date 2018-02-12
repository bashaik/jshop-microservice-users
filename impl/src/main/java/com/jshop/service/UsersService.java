
package com.jshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshop.auth.AuthProviderException;
import com.jshop.auth.IAuthProvider;
import com.jshop.auth.TokenData;
import com.jshop.core.logging.JShopLogger;

@Service
public class UsersService implements IUserService
{
    private static final JShopLogger LOGGER = new JShopLogger(UsersService.class);
    
    @Autowired
    private IAuthProvider authProvider;
    
    @Override
    public LoginResponse login(LoginRequest loginRequest)
    {
    		authenicateUser(loginRequest);
    		
        LoginResponse response = new LoginResponse();
        
        String token = generateToken(loginRequest);
        
        response.setUserName(loginRequest.getUserName());
        response.setToken(token);

        return response;
    }


	private void authenicateUser(LoginRequest loginRequest) {
		if (!loginRequest.getUserName().equals("test") || !loginRequest.getPassword().equals("test"))
		{
			throw new JShopServiceException("Invalid userName/Password");
		}
	}
	
	private String generateToken(LoginRequest loginRequest) {
		TokenData tokenData = new TokenData();
        tokenData.setUserName(loginRequest.getUserName());
        tokenData.setTenant(loginRequest.getTenant());
        String token = null;
        try {
        		token = authProvider.generateToken(tokenData);
		} catch (AuthProviderException e) {
			// IGNORE
		}
		return token;
	}

}
