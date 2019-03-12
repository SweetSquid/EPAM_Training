package project.model.entity;

import project.model.NotUniqueSongException;
import java.util.List;


public class Disc {
    private List<Song> disc;

    public Disc(List<Song> disc) {
        this.disc = disc;
    }

    /**
     * Adds song to the disc if it's unique.
     * @param song checks song styles
     * @throws NotUniqueSongException if song already in
     */
    public void addToDisc(Song song) throws NotUniqueSongException {
        if (uniqueSong(song)) {
            disc.add(song);
        }else throw new NotUniqueSongException();
    }

    /**
     * Deletes song if it's already in.
     * @param songName song name
     * @param  author song author
     */
    public void deleteFromDisc(String songName, String author) {
        disc.removeIf(t -> t.getName().equals(songName) && t.getAuthor().equals(author));
    }

    public List<Song> getDisc() {
        return disc;
    }

    /**
     * checks the song for uniqueness
     * @param song Song object
     * @return true if the song is unique
     */
   public boolean uniqueSong(Song song) {
        for (Song s : disc) {
            if (s.getAuthor().equals(song.getAuthor()) && s.getName().equals(song.getName())) {
                return false;
            }
        }
        return true;
    }


}
