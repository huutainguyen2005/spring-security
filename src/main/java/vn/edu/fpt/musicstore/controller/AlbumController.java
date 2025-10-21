package vn.edu.fpt.musicstore.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.fpt.musicstore.entities.Album;
import vn.edu.fpt.musicstore.services.AlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping
    public String list(Model model, @RequestParam(name = "page", required = false, defaultValue = "1") int page) {

        Pageable pageable = PageRequest.of(page - 1, 20);
        Page<Album> albumPage = albumService.getAllAlbums(pageable);

        model.addAttribute("albums", albumPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", albumPage.getTotalPages());
        model.addAttribute("totalItems", albumPage.getTotalElements());
        return "ablum/list";
    }
}
