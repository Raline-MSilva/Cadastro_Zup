package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public void realizarCadastro(CadastroDTO cadastroDTO) {
        cadastroRepository.save(cadastrarPessoa(cadastroDTO));
    }

    public Cadastro cadastrarPessoa(CadastroDTO cadastroDTO) {
        LocalDate dataAtual = LocalDate.now();
        Cadastro cadastro1 = new Cadastro();

        cadastro1.setCpf(cadastroDTO.getCpf());
        cadastro1.setNome(cadastroDTO.getNome());
        cadastro1.setSobrenome(cadastroDTO.getSobrenome());
        cadastro1.setCidade(cadastroDTO.getCidade());
        cadastro1.setBairro(cadastroDTO.getBairro());
        cadastro1.setNomeDoParenteProximo(cadastroDTO.getNomeDoParenteProximo());
        cadastro1.setMoraSozinho(cadastroDTO.isMoraSozinho());
        cadastro1.setTemPet(cadastroDTO.isTemPet());
        cadastro1.setIdade(cadastroDTO.getIdade());
        cadastro1.setDataDoCadastro(LocalDate.now());

        return cadastro1;
    }
    public List<Cadastro>mostrarTodosOsCadastros (){
        Iterable<Cadastro> cadastros = cadastroRepository.findAll();
        return (List<Cadastro>) cadastros;
    }

    public List<Cadastro>mostrarQuemMoraSozinho (boolean moraSozinho){
        Iterable<Cadastro> cadastros = cadastroRepository.findAllByMoraSozinho(moraSozinho);
        return (List<Cadastro>) cadastros;
    }

}
