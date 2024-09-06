package com.van.hexagonal.application.controller.rest;

import com.van.hexagonal.application.dto.CreateUserAccountRequest;
import com.van.hexagonal.application.dto.UserAccountResponse;
import com.van.hexagonal.core.mappers.UserAccountMapper;
import com.van.hexagonal.domain.model.UserAccount;
import com.van.hexagonal.domain.provider.IRoleProvider;
import com.van.hexagonal.domain.provider.IUserAccountProvider;
import com.van.hexagonal.domain.provider.IUserAccountSessionProvider;
import com.van.hexagonal.domain.service.IUserAccountService;
import com.van.hexagonal.domain.service.userAccount.UserAccountServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserAccountRestController {

    private final IUserAccountProvider userAccountProvider;

    private final IRoleProvider roleProvider;

    private final IUserAccountSessionProvider userAccountSessionProvider;

    private IUserAccountService userAccountService;

    @Autowired
    public UserAccountRestController(IUserAccountProvider userAccountProvider, IRoleProvider roleProvider, IUserAccountSessionProvider userAccountSessionProvider) {
        this.userAccountProvider = userAccountProvider;
        this.roleProvider = roleProvider;
        this.userAccountSessionProvider = userAccountSessionProvider;
         userAccountService = new UserAccountServiceImpl(userAccountProvider, roleProvider, userAccountSessionProvider);

    }


    @PostMapping(value = "")
    public ResponseEntity<UserAccountResponse> create(@RequestBody CreateUserAccountRequest request){
//        this.userAccountService=userAccountService();
        UserAccount userAccount=UserAccountMapper.dtoCreateToModelDomain(request);
        return ResponseEntity.ok().body(UserAccountMapper.modelDomainToDto(userAccountService.createUserAccount(userAccount)));
   }

}
