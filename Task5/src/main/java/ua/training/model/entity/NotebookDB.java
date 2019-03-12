package ua.training.model.entity;

public enum NotebookDB {
    Sasha("Oleksandr","sashasuper","sasha@gmail.com"),
    Kolya("Kolya","qwe12345","kolya@gmail.com"),
    Masha("Masha","prosto123","masha@gmail.com");

    private String name;
    private String login;
    private String email;

    NotebookDB(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getLogin(){
        return login;
    }

    public String getEmail(){
        return email;
    }

    public static boolean checkLogin(String login){
        for (NotebookDB nb: NotebookDB.values()) {
           if (login.equals(nb.login)){
                return false;
           }
        }
        return true;
    }

    public static boolean checkEmail(String email){
        for (NotebookDB nb: NotebookDB.values()) {
           if (email.equals(nb.login)){
                return false;
           }
        }
        return true;
    }
}
