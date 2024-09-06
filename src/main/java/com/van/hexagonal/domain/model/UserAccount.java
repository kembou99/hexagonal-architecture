package com.van.hexagonal.domain.model;

import java.util.Set;

public class UserAccount {

    public UserAccount() {
    }

    private Long id;

    private String username;

    private String password;

    private boolean isEnable;

    private  boolean logged;

    private String language;

    private Role role;

    public UserAccount(Long id, String username, String password, boolean isEnable, boolean logged, String language, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isEnable = isEnable;
        this.logged = logged;
        this.language = language;
        this.role = role;
    }

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public boolean isEnable() {
        return isEnable;
    }


    public boolean isLogged() {
        return logged;
    }


    public String getLanguage() {
        return language;
    }


    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static UserAccountBuilder builder(){

        return  new UserAccountBuilder();
    }

   public static class UserAccountBuilder{
        private  Long id;

        private  String username;

        private  String password;

        private  boolean isEnable=true;

        private    boolean logged=false;

        private  String language;

        private  Role role;


        public UserAccountBuilder id(Long id_){
               this.id=id_;
                return this;
        }
        public UserAccountBuilder username(String username_){
            this.username=username_;
            return this;
        }
        public UserAccountBuilder password(String password_){
            this.password=password_;
            return this;
        }
        public UserAccountBuilder isEnable(boolean isEnable_){
            this.isEnable=isEnable_;
            return this;
        }
        public UserAccountBuilder logged(boolean logged_){
            this.logged=logged_;
            return this;
        }

        public UserAccountBuilder language(String language_){
            this.language=language_;
            return this;
        }

        public UserAccountBuilder role(Role role_){
            this.role=role_;
            return this;
        }

        public  UserAccount build(){
               return new UserAccount(id,username,password,isEnable,logged,language,role);
        }

    }

}
