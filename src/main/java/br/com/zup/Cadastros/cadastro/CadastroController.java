package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.dtos.CadastroDTO;
import br.com.zup.Cadastros.dtos.ResumoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;


    @PostMapping
    public void cadastrarPessoa(@RequestBody CadastroDTO cadastroDTO) {
        cadastroService.realizarCadastro(cadastroDTO);
    }

    @GetMapping
    public List<ResumoDTO> mostrarTodosOsCadastros(@RequestParam (required = false) Boolean moraSozinho,
                                                   @RequestParam (required = false) Boolean temPet,
                                                   @RequestParam (required = false) Integer idade) {
        List<ResumoDTO> todosOsCadastros = new ArrayList<>();

        for (Cadastro cadastro : cadastroService.mostrarCadastrosEspecificos(moraSozinho, temPet, idade)) {
            todosOsCadastros.add(new ResumoDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome()));
        }

        return todosOsCadastros;

    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deletarCpf (@PathVariable String cpf){
        cadastroService.deletarPorCpf(cpf);
    }



    /*
    todo  1 - crie um metodo para cadastrar uma pessoa.
      Para um cadastro todo os campos são obrigatórios EXCETO o campo dataDoCadastro que deve ser preenchido pelo proprio sistema e o client não deve saber da existencia desse campo
     todo 2 - Faça um metodo que retorna a lista inteira de cadastros ou filtrado por cadastros que moram sozinhos, que tem pet ou por idade.
     nessa lista deve ser retornado apenas os campos ID, NOME e SOBRENOME.
     todo 3 - faça um metodo para DELETAR um cadastro por id.
     todo 4 - faça um metodo que retorna TODOS os dados de um usuario pesquisado pelo ID.
     */

}
