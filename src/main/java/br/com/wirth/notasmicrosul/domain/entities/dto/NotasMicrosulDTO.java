package br.com.wirth.notasmicrosul.domain.entities.dto;

import br.com.wirth.notasmicrosul.domain.entities.NotasMicrosul;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class NotasMicrosulDTO implements Comparable<NotasMicrosulDTO> {

    private String numeronf;
    private LocalDateTime data;
    private String tipoItem;
    private String quantidade;
    private String notaDevolucao;

    public NotasMicrosulDTO(NotasMicrosul notasMicrosul) {
        this.numeronf = notasMicrosul.getId().getNumeronf();
        this.data = LocalDateTime.of(notasMicrosul.getId().getData(), LocalTime.now());
        this.tipoItem = notasMicrosul.getId().getTipoItem();
        this.quantidade = notasMicrosul.getQuantidade();
        this.notaDevolucao = notasMicrosul.getNotaDevolucao();
    }

    @Override
    public int compareTo(NotasMicrosulDTO o) {
        return getData().compareTo(o.getData());
    }
}
