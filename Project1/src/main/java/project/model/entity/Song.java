package project.model.entity;

public class Song {
    private int duration;
    private String name;
    private String author;
    private String style;

    public Song(String name, String author, String style, int duration) {
        this.name = name;
        this.author = author;
        this.style = style;
        this.duration = duration;
    }

    public String getStyle() {
        return style;
    }

    String getAuthor() {
        return author;
    }

    String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }


    @Override
    public String toString() {
        return "Name: " + getName() + ", " +
                "author: " + getAuthor() + ", " +
                "style: " + getStyle() + ", " +
                "duration: " + getDuration();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Song song = (Song) obj;
        return song.getName().equals(name) && song.getAuthor().equals(author) && song.getStyle().equals(style);
    }
}
