package br.com.wirth.notasmicrosul.services;

import br.com.wirth.notasmicrosul.domain.entities.NotasMicrosul;
import br.com.wirth.notasmicrosul.domain.entities.NotasMicrosulId;
import br.com.wirth.notasmicrosul.domain.entities.dto.NotasMicrosulDTO;
import br.com.wirth.notasmicrosul.domain.repositories.NotasMicrosulRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NotasMicrosulService {
    private final NotasMicrosulRepository notasMicrosulRepository;

    public NotasMicrosulService(NotasMicrosulRepository notasMicrosulRepository) {
        this.notasMicrosulRepository = notasMicrosulRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public NotasMicrosulDTO salvaNota(NotasMicrosulDTO nota) {
        NotasMicrosulId id = new NotasMicrosulId(nota.getNumeronf(), nota.getData().toLocalDate(), nota.getTipoItem());
        NotasMicrosul novaNota = new NotasMicrosul();
        novaNota.setId(id);
        novaNota.setQuantidade(nota.getQuantidade());
        novaNota.setNotaDevolucao("");

        return new NotasMicrosulDTO(this.notasMicrosulRepository.save(novaNota));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public NotasMicrosulDTO notaDevolucao(NotasMicrosulDTO nota) {
        NotasMicrosulId id = new NotasMicrosulId(nota.getNumeronf(), nota.getData().toLocalDate(), nota.getTipoItem());
        NotasMicrosul notaAtualizar = this.notasMicrosulRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nota não encontrada."));
        notaAtualizar.setNotaDevolucao(nota.getNotaDevolucao());

        return new NotasMicrosulDTO(notaAtualizar);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void deletaCampo(NotasMicrosulId id) {
        Optional<NotasMicrosul> nota = this.notasMicrosulRepository.findById(id);
        nota.ifPresent(this.notasMicrosulRepository::delete);
    }

    public List<NotasMicrosulDTO> buscaNotas() {
        List<NotasMicrosulDTO> lista = new java.util.ArrayList<>(this.notasMicrosulRepository.findAll().stream().map(NotasMicrosulDTO::new).toList());
        Collections.sort(lista);
        Collections.reverse(lista);
        return lista;
    }
}
