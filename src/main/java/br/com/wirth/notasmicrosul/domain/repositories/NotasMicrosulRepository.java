package br.com.wirth.notasmicrosul.domain.repositories;

import br.com.wirth.notasmicrosul.domain.entities.NotasMicrosul;
import br.com.wirth.notasmicrosul.domain.entities.NotasMicrosulId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasMicrosulRepository extends JpaRepository<NotasMicrosul, NotasMicrosulId> {

}