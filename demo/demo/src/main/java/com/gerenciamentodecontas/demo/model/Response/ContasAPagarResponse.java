package com.gerenciamentodecontas.demo.model.Response;
import com.gerenciamentodecontas.demo.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasAPagarResponse {

    private Long id;
    private String nome;
    private Double valor;
    private Status status;
}
