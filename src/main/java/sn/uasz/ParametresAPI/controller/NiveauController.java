package sn.uasz.ParametresAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sn.uasz.ParametresAPI.entities.Niveau;
import sn.uasz.ParametresAPI.repository.NiveauRepository;

import jakarta.validation.Valid;

import java.util.List;

//@Controller
//public class NiveauController {
//
//    private final NiveauRepository niveauRepository;
//
//    public NiveauController(NiveauRepository niveauRepository) {
//        this.niveauRepository = niveauRepository;
//    }
//
//    // 📄 Afficher tous les niveaux
//    @GetMapping("/indexNiveaux")
//    public String index(Model model) {
//        model.addAttribute("listeNiveaux", niveauRepository.findAll());
//        return "niveau/niveau";
//    }
//
//    // ➕ Formulaire d'ajout
//    @GetMapping("/formNiveau")
//    public String form(Model model) {
//        model.addAttribute("niveau", new Niveau());
//        return "niveau/formNiveau";
//    }
//
//    // 💾 Enregistrer un niveau
//    @PostMapping("/saveNiveau")
//    public String save(@Valid @ModelAttribute Niveau niveau, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) return "niveau/formNiveau";
//        niveauRepository.save(niveau);
//        return "redirect:/indexNiveaux";
//    }
//
//    // 🔍 Rechercher un niveau par ID
//    @GetMapping("/getNiveau")
//    public String getNiveau(Model model, @RequestParam("id") Long id) {
//        Niveau niveau = niveauRepository.findById(id).orElse(null);
//        if (niveau == null) throw new RuntimeException("Niveau introuvable");
//        model.addAttribute("niveau", niveau);
//        return "niveau/detailNiveau";
//    }
//
//    // ✏️ Formulaire de modification
//    @GetMapping("/editNiveau")
//    public String edit(Model model, @RequestParam("id") Long id) {
//        Niveau niveau = niveauRepository.findById(id).orElse(null);
//        if (niveau == null) throw new RuntimeException("Niveau introuvable");
//        model.addAttribute("niveau", niveau);
//        return "niveau/editNiveau";
//    }
//
//    // ✅ Mettre à jour un niveau
//    @PostMapping("/updateNiveau")
//    public String update(@Valid @ModelAttribute Niveau niveau, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) return "niveau/editNiveau";
//        niveauRepository.save(niveau);
//        return "redirect:/indexNiveaux";
//    }
//
//    // ❌ Supprimer un niveau
//    @GetMapping("/deleteNiveau")
//    public String delete(@RequestParam("id") Long id) {
//        niveauRepository.deleteById(id);
//        return "redirect:/indexNiveaux";
//    }
//
//    // 🔍 Recherche par nom
//    @GetMapping("/searchNiveau")
//    public String search(Model model,
//                         @RequestParam(name = "keyword", required = false) String keyword) {
//        if (keyword != null && !keyword.isEmpty()) {
//            model.addAttribute("listeNiveaux", niveauRepository.findByNomContainingIgnoreCase(keyword, null));
//        } else {
//            model.addAttribute("listeNiveaux", niveauRepository.findAll());
//        }
//        return "niveau/niveau";
//    }
//}

@RestController
@RequestMapping("/niveaux")
public class NiveauController {

    private final NiveauRepository niveauRepository;

    public NiveauController(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    // 👉 Ajouter un niveau
    @PostMapping
    public Niveau save(@RequestBody Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    // 👉 Lister tous les niveaux
    @GetMapping
    public List<Niveau> getAll() {
        return niveauRepository.findAll();
    }

    // 👉 Chercher un niveau par ID
    @GetMapping("/{id}")
    public Niveau getNiveau(@PathVariable Long id) {
        return niveauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Niveau introuvable"));
    }

    // 👉 Supprimer un niveau
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        niveauRepository.deleteById(id);
    }

    // 👉 Mettre à jour un niveau
    @PutMapping("/{id}")
    public Niveau update(@PathVariable Long id, @RequestBody Niveau updatedNiveau) {
        Niveau niveau = niveauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Niveau introuvable"));
        niveau.setNom(updatedNiveau.getNom());
        return niveauRepository.save(niveau);
    }
}
