package com.luxnet.testTask.contollers;

import com.luxnet.testTask.models.Employee;
import com.luxnet.testTask.models.Position;
import com.luxnet.testTask.repo.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PositionController {

    @Autowired
    private IPositionRepository positionRepository;

    @GetMapping("/positionlist")
    public String getpositions (Model model) {
        Iterable<Position> positions = positionRepository.findAll();
        model.addAttribute("positions", positions);
        return "position-list";
    }

    @GetMapping("/add/Position")
    public String addPosition(Model model) {
        return "add-position";
    }

    @PostMapping("/add/Position")
    public String addedEmployee(@RequestParam Long id, @RequestParam String name, Model model) {
        Position position = new Position(id, name);
        positionRepository.save(position);
        return "redirect:/positionlist";
    }
}
