package com.van.hexagonal.domain.model;

public class Role {

    private Long id;
    private String name;

    private String description;

    public Role(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;

    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Role setDescription(String description) {
        this.description = description;
        return this;
    }

    public static RoleBuilder builder(){
        return new RoleBuilder();
    }

    public static class RoleBuilder{
        private Long id;
        private String name;
        private String description;

        public RoleBuilder() {
        }

        public RoleBuilder id(Long id){
            this.id=id;
            return this;
        }

        public RoleBuilder name(String name){
            this.name=name;
            return this;
        }
        public RoleBuilder description(String description){
             this.description=description;
             return this;
        }
        public Role build(){
             return new Role(this.id,this.name,this.description);
        }
    }
}
