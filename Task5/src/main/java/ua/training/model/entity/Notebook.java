package ua.training.model.entity;

public class Notebook {

    private String name;
    private String login;
    private String email;

    public Notebook(String name, String login, String email) throws WrongEmailException, WrongLoginException {
        if (!NotebookDB.checkLogin(login)){
            throw new WrongLoginException("It is not unique, please input another login");
        }
        if (!NotebookDB.checkEmail(email)){
            throw new WrongEmailException("It is not unique, please input another email");
        }
        this.email = email;
        this.name = name;
        this.login = login;

    }

//    public void setSecondNameNotebook(String secondName){
//        this.secondName = secondName;
//    }

    public void setLoginNotebook(String login) {
        this.login = login;
    }

    public void setEmailNotebook(String email){
        this.email = email;
    }

//    public void setPhoneNotebook(String phone){
//        this.phone = phone;
//    }

    public String getNameNotebook(){
        return name;
    }

//    public String getSecondName(){
//        return secondName;
//    }

    public String getLogin(){
        return login;
    }

    public String getEmail(){
        return email;
    }

//    public String getPhone(){
//        return phone;
//    }


    @Override
    public String toString() {
        return "Name: " + name +
                ", login: " + login+
                ", email: " + email;
    }
}
