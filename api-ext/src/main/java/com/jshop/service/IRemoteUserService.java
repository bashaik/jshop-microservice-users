
package com.jshop.service;

import com.jshop.core.common.Constants;

public interface IRemoteUserService
{
    String USERS_URL = Constants.ROOT_PATH + "/users";
    
    LoginResponse login(LoginRequest loginRequest);
}
