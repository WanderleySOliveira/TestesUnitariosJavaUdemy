package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Test
    @DisplayName("Responsavel por realizar o teste do metodo Alugar filme da classe LocacaoService")
    public void deveTestarOMetodoService() {
        //Cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Matrix", 5, 10.00);

        //Ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //Verificação
        assertEquals(10.00, locacao.getValor(), 0.01);
        assertThat(locacao.getValor(), is(10.0));
        assertThat(locacao.getValor(), is(not(6.00)));

        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

        //Mesmo sentido da assertiva acima porém utilizando o metod assertThat
        assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
    }
}