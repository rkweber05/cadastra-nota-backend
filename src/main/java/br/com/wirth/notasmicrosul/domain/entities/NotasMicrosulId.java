package br.com.wirth.notasmicrosul.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class NotasMicrosulId implements Serializable {

    @Column(name = "NUMERONF", nullable = false)
    private String numeronf;

    @Column(name = "DATA", nullable = false)
    private LocalDate data;

    @Column(name = "TIPO_ITEM", nullable = false)
    private String tipoItem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotasMicrosulId that = (NotasMicrosulId) o;
        return Objects.equals(numeronf, that.numeronf) && Objects.equals(data, that.data) && Objects.equals(tipoItem, that.tipoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeronf, data, tipoItem);
    }
}
