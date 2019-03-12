package project.model;

import project.model.entity.Disc;
import project.model.entity.Song;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ActionsWithSongs {
    private Disc disc;

    public ActionsWithSongs(Disc disc) {
        this.disc = disc;
    }

    /**
     * Gives full duration on the disc.
     * @return full duration
     */

    public int getFullDuration() {
        return disc.getDisc().stream()
                .mapToInt(Song::getDuration)
                .sum();
    }

    /**
     * Sorts songs by alphabets.
     * @return sorted songs
     */

    public List<Song> songsSortByStyleName() {
        return disc.getDisc().stream()
                .sorted(Comparator.comparing(Song::getStyle))
                .collect(Collectors.toList());
    }

    /**
     * Returns songs in the specified style.
     * @param style checks song styles
     * @return songs with given style
     */
    public List<Song> songsByStyle(String style){
        return disc.getDisc().stream()
                .filter(song -> song.getStyle().equals(style))
                .collect(Collectors.toList());
    }

    /**
     * Сhecks songs in a given range
     * @param from beginning of range
     * @param to end of range
     * @return songs in given range
     */
    public List<Song> songsByRange(int from, int to) {
        return disc.getDisc().stream()
                .filter(song -> song.getDuration() <= to && song.getDuration() >= from)
                .collect(Collectors.toList());
    }
}