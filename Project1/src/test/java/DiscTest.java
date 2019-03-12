import project.model.entity.Disc;
import project.model.NotUniqueSongException;
import project.model.entity.Song;
import project.model.Styles;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;


public class DiscTest {
    private Disc disc;

    @Before
    public void initObj() {
        disc = new Disc(new ArrayList<Song>() {{
            add(new Song("Beautiful", "Bazzi", Styles.POP.getStyle(), 120));
            add((new Song("Dream", "Imagine Dragons", Styles.INDIEROCK.getStyle(), 258)));
            add((new Song("Psycho", "Post Malone", Styles.RAP.getStyle(), 156)));
            add((new Song("Demons", "Imagine Dragons", Styles.INDIEROCK.getStyle(), 232)));
        }});
    }

    @Test
    public void uniqueSongTest() {
        boolean actualResult1 = disc.uniqueSong(new Song("Dream", "Imagine Dragons", Styles.INDIEROCK.getStyle(), 258));
        boolean actualResult2 = disc.uniqueSong(new Song("AJR", "I'm Not Famous", Styles.POP.getStyle(), 238));
        assertFalse(actualResult1);
        assertTrue(actualResult2);
    }

    @Test
    public void addToDiscTest() throws NotUniqueSongException {
        int expectedSize = disc.getDisc().size() + 1;
        disc.addToDisc(new Song("Chlorine", "Twenty One Pilots", Styles.ALTERNATIVE.getStyle(), 310));
        int actualSize = disc.getDisc().size();
        assertEquals(expectedSize, actualSize);

    }

    @Test
    public void deleteFromDiscTest() {
        int expectedSize = disc.getDisc().size() - 1;
        disc.deleteFromDisc("Dream", "Imagine Dragons");
        int actualSize = disc.getDisc().size();
        assertEquals(expectedSize, actualSize);
    }
}
