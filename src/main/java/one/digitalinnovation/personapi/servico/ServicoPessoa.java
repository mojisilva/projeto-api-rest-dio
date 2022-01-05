package one.digitalinnovation.personapi.servico;

import one.digitalinnovation.personapi.dto.pedido.PessoaDTO;
import one.digitalinnovation.personapi.dto.resposta.MessagemResposta;
import one.digitalinnovation.personapi.entidades.Pessoa;
import one.digitalinnovation.personapi.mapeador.MapeadorPessoa;
import one.digitalinnovation.personapi.repositorio.RepositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoPessoa {

    private RepositorioPessoa repositorioPessoa;

    private final MapeadorPessoa mapeadorPessoa = MapeadorPessoa.INSTANCE;

    @Autowired
    public ServicoPessoa(RepositorioPessoa repositorioPessoa)  {
        this.repositorioPessoa = repositorioPessoa;
    }

    public MessagemResposta criaPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = mapeadorPessoa.toModel(pessoaDTO);
        Pessoa pessoaSalva = repositorioPessoa.save(pessoa);

        return MessagemResposta
                .builder()
                .mensagem("Pessoa criada com ID:" + pessoaSalva.getId())
                .build();
    }
}
