package models;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class admin implements Serializable {

    private String id;
    private String name;
    private String username;
    private String code;
    private String pass;
    private String email;
    private int permission;

    public admin() {

    }

    public admin(String name, String username, String code, String pass, String email, int permission) {
        this.name = name;
        this.username = username;
        this.code = code;
        this.pass = pass;
        this.email = email;
        this.permission = permission;
    }
    /**
     * Esta función permite verificar si el objeto creado en base a esta clase contiene el permiso de administrador
     * dicho esto, puede estar sujeto a 2 tipos de valores distintos
     * '1' Corresponde a un administrador de control total
     * '2' Corresponde a un administrador con permisos limitados
     * @param this.permission
     * @return boolean
     */
    public boolean isAdmin(){
        if(this.permission == 1)
            return true;
        return false;
    }

    public admin(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

}
