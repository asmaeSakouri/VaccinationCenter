package com.example.vaccinationcenter.web;

import com.example.vaccinationcenter.entities.CentreVaccination;
import com.example.vaccinationcenter.entities.Citoyen;
import com.example.vaccinationcenter.repositories.CentreVaccinationRepository;
import com.example.vaccinationcenter.repositories.CitoyenRepository;
import com.example.vaccinationcenter.service.CentreService;
import com.example.vaccinationcenter.service.CitoyenService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class VaccinationController {
    private CentreService centreService;
    private CitoyenService citoyenService;
    private CitoyenRepository citoyenRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("citoyens", citoyenService.getCitoyens());
        model.addAttribute("centres", centreService.getCentreVaccinations());
        return "index";
    }
    @GetMapping(path = "/searchCitoyens")
    public String citoyensByCenter(Model model,
                           @RequestParam(name = "page",defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "3") int size,
                           @RequestParam(name = "keyword",defaultValue = "0") Long id){
        if (id == null || id < 0) {
            // Gérer le cas où l'ID est nul ou négatif
            // Vous pouvez rediriger vers une page d'erreur ou effectuer une autre action
            return "errorPage"; // Remplacez "errorPage" par le nom de votre vue d'erreur
        }
        Page<Citoyen> citoyens=citoyenRepository.findByCentreVaccination_Id(id, PageRequest.of(page,size));
        model.addAttribute("listCitoyens",citoyens.getContent());
        model.addAttribute("pages",new int[citoyens.getTotalPages()]);
        model.addAttribute("current",page);
        model.addAttribute("keyword",id);
        return "searchCitoyens";
    }

    @GetMapping("/addCitoyen")
    public String showCitoyenForm(Model model) {
        model.addAttribute("citoyen", new Citoyen());
        model.addAttribute("centres",centreService.getCentreVaccinations());
        return "addCitoyen";
    }

    @PostMapping("/addCitoyen")
    public String addCitoyen(@ModelAttribute("citoyen") Citoyen citoyen) {
        citoyenService.saveCitoyen(citoyen);
        return "redirect:/";
    }

    @GetMapping("/addCentre")
    public String showCentreForm(Model model) {
        model.addAttribute("centre", new CentreVaccination());
        return "addCentre";
    }

    @PostMapping("/addCentre")
    public String addCentre(@ModelAttribute("centre") CentreVaccination centre) {
        centreService.saveCentre(centre);
        return "redirect:/";
    }
}

