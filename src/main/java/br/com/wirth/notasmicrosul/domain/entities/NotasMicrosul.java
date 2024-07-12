package br.com.wirth.notasmicrosul.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "NOTAS_MICROSUL")
public class NotasMicrosul implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @EmbeddedId
    private NotasMicrosulId id;

    @Column(name = "QUANTIDADE", nullable = false)
    private String quantidade;

    @Column(name = "NOTA_DEVOLUCAO")
    private String notaDevolucao;
}
