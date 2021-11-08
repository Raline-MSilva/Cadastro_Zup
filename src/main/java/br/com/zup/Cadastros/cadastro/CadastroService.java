package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public void realizarCadastro(Cadastro cadastro) {
        cadastroRepository.save(cadastrarPessoa(cadastro));
    }

    public Cadastro cadastrarPessoa(Cadastro cadastro) {
        Cadastro cadastro1 = new Cadastro();

        cadastro1.setCpf(cadastro.getCpf());
        cadastro1.setNome(cadastro.getNome());
        cadastro1.setSobrenome(cadastro.getSobrenome());
        cadastro1.setCidade(cadastro.getCidade());
        cadastro1.setBairro(cadastro.getBairro());
        cadastro1.setNomeDoParenteProximo(cadastro.getNomeDoParenteProximo());
        cadastro1.setMoraSozinho(cadastro.isMoraSozinho());
        cadastro1.setTemPet(cadastro.isTemPet());
        cadastro1.setIdade(cadastro.getIdade());

        cadastroRepository.save(cadastro);

        return cadastro1;
    }
}
