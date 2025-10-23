package Controllers; // O com.gestor.gestor.controllers si lo estandarizaste

import Services.IngresoService; // O el paquete correcto
import com.gestor.gestor.entitys.Ingreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestor/ingreso")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @GetMapping
    public List<Ingreso> getAllIngresos() {
        return ingresoService.getAllIngresos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingreso> getIngresoById(@PathVariable Long id) {
        return ingresoService.getIngresoById(id)
                .map(ingreso -> new ResponseEntity<>(ingreso, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Devuelve 201 Created al crear
    public Ingreso createIngreso(@RequestBody Ingreso ingreso) {
        return ingresoService.saveIngreso(ingreso);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Ingreso> updateIngreso(@PathVariable Long id, @RequestBody Ingreso ingresoDetails) {
        try {
            Ingreso updatedIngreso = ingresoService.updateIngreso(id, ingresoDetails);
            return new ResponseEntity<>(updatedIngreso, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngreso(@PathVariable Long id) {
        try {
            ingresoService.deleteIngreso(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}