package project.model;

public enum Styles {
    POP("Pop"),
    ROCK("Rock"),
    HIPHOP("Hip Hop"),
    JAZZ("Jazz"),
    ALTERNATIVE("Alternative"),
    CLASSICAL("Classical"),
    RAP("Rap"),
    INDIEROCK("Indie Rock");

    private String style;

    Styles(String style){
        this.style = style;
    }

    public String getStyle(){
        return style;
    }

}
