package br.com.wirth.notasmicrosul.resources;

import br.com.wirth.notasmicrosul.domain.entities.NotasMicrosulId;
import br.com.wirth.notasmicrosul.domain.entities.dto.NotasMicrosulDTO;
import br.com.wirth.notasmicrosul.services.NotasMicrosulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotasMicrosulResource {

    private final NotasMicrosulService notasMicrosulService;

    public NotasMicrosulResource(NotasMicrosulService notasMicrosulService) {
        this.notasMicrosulService = notasMicrosulService;
    }

    @PutMapping("/novo")
    @CrossOrigin("*")
    public ResponseEntity<NotasMicrosulDTO> novaNota(@RequestBody NotasMicrosulDTO dto) {
        return ResponseEntity.ok().body(this.notasMicrosulService.salvaNota(dto));
    }

    @PostMapping("/devolucao")
    @CrossOrigin("*")
    public ResponseEntity<NotasMicrosulDTO> novaDevolucao(@RequestBody NotasMicrosulDTO dto) {
        return ResponseEntity.ok().body(this.notasMicrosulService.notaDevolucao(dto));
    }

    @GetMapping("/listar")
    @CrossOrigin("*")
    public ResponseEntity<List<NotasMicrosulDTO>> listar() {
        return ResponseEntity.ok().body(this.notasMicrosulService.buscaNotas());
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    public ResponseEntity<?> deletaNota(@RequestBody NotasMicrosulDTO dto) {
        this.notasMicrosulService.deletaCampo(new NotasMicrosulId(dto.getNumeronf(), dto.getData().toLocalDate(), dto.getTipoItem()));
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
