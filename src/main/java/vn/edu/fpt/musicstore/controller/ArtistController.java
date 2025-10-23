package vn.edu.fpt.musicstore.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.fpt.musicstore.entities.Album;
import vn.edu.fpt.musicstore.entities.Artist;
import vn.edu.fpt.musicstore.services.ArtistService;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping
    public String list(Model model, @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                       Authentication authentication, HttpSession session) {

        UserDetails userDetails =  (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());

        Page<Artist> artistPage = artistService.getAllArtists(PageRequest.of(page - 1, 20));

        model.addAttribute("artists", artistPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", artistPage.getTotalPages());
        model.addAttribute("totalItems", artistPage.getTotalElements());

        session.setAttribute("artists", artistPage);
        return "artist/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("artist", artistService.findById(id));
        return "artist/edit";
    }

    @RequestMapping(value = "/new")
    public String newArtist(Model model) {
        model.addAttribute("artist", new Artist());
        return "artist/create";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteArtist(Model model, @PathVariable("id") int id) {
        System.out.println("Artist id:" + id);
        model.addAttribute("artist", artistService.findById(id));
        return "artist/delete";
    }

    @RequestMapping(value = "/save")
    public String save(@ModelAttribute(name = "artist") Artist artist) {
        System.out.println("Artist name:" + artist.getArtistName());
        artistService.save(artist);
        return "redirect:/artist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute(name = "artist") Artist artist) {
        System.out.println("Artist id:" + artist.getArtistId());
        artistService.deleteById(artist.getArtistId());
        return "redirect:/artist";
    }

    @GetMapping("/{id}")
    public String getArtistDetails(@PathVariable("id") int id, Model model) {
        Artist artist = artistService.findById(id);
        List<Album> albums = artist.getAlbums();

        model.addAttribute("artist", artist);
        model.addAttribute("albums", albums);
        return "artist/detail";
    }
}