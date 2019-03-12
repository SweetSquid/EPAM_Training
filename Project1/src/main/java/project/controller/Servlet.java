package project.controller;

import project.model.*;
import project.model.entity.Disc;
import project.model.entity.Song;
import project.view.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class Servlet extends HttpServlet {
    private Disc disc = new Disc(new ArrayList<Song>() {{
        add(new Song("Beautiful", "Bazzi", Styles.POP.getStyle(), 120));
        add((new Song("Dream", "Imagine Dragons", Styles.INDIEROCK.getStyle(), 258)));
        add((new Song("Psycho", "Post Malone", Styles.RAP.getStyle(), 156)));
    }});
    private ActionsWithSongs actionSong = new ActionsWithSongs(disc);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setAttribute("discs", disc.getDisc());
        request.setAttribute("genre", Styles.values());
        request.setAttribute("fullDuration", actionSong.getFullDuration());
        request.setAttribute("songsSortByStyle", actionSong.songsSortByStyleName());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!request.getParameter("name").equals("") && !request.getParameter("author").equals("") &&
                !request.getParameter("genre").equals("") && !request.getParameter("duration").equals("")) {
            try {
                disc.addToDisc(new Song(request.getParameter("name"),
                        request.getParameter("author"),
                        request.getParameter("genre"),
                        Integer.parseInt(request.getParameter("duration"))));
            } catch (NotUniqueSongException e) {
                request.setAttribute("errorMessage", View.bundle.getString(MessageConstants.ERROR));
            }
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("author", request.getParameter("author"));
            request.setAttribute("genre", request.getParameter("genre"));
            request.setAttribute("duration", Integer.parseInt(request.getParameter("duration")));
        }

        disc.deleteFromDisc(request.getParameter("deleteSongName"), request.getParameter("deleteSongAuthor"));

        if (actionSong.songsByStyle(request.getParameter("style")).isEmpty()) {
            request.setAttribute("songsByStyleError", View.bundle.getString(MessageConstants.NO_SONG_BY_GENRE));
        } else {
            request.setAttribute("songsByStyle", actionSong.songsByStyle(request.getParameter("style")));
        }

        if (!request.getParameter("minRange").equals("") && !request.getParameter("maxRange").equals("") &&
                !actionSong.songsByRange(Integer.parseInt(request.getParameter("minRange")), Integer.parseInt(request.getParameter("maxRange"))).isEmpty()) {
            request.setAttribute("songsByRange", actionSong.songsByRange(
                    Integer.parseInt(request.getParameter("minRange")),
                    Integer.parseInt(request.getParameter("maxRange"))));
        } else {
            request.setAttribute("songsByRangeError", View.bundle.getString(MessageConstants.NO_SONG_IN_RANGE));
        }
        doGet(request, response);
    }
}
