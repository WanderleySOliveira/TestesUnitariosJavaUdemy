package br.com.wanderley.udemy.testesunitarios.servicos;

import br.com.wanderley.udemy.testesunitarios.entidades.Usuario;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void test() {
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        var soma = 1 + 1;
        var resultSoma = 2;

        //Realiza a comparação de igualdade de valores
        Assert.assertEquals(resultSoma , soma);

        //Para o tipo Double é necessario acrescer mais um argumento (Delta de comparação)
        // que permite considerar uma margem de erro na comparação através da indicação de qtd de casas decimais que devemos considerar,
        // no cenario abaixo o ultimo argumento(Delta) é o responsavel por essa indicação (0.01)
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        //Esse metodo não consegue fazer comparação entre tipoPrimitivo e Wrappers, para isso é necessario converter, conforme exemplo abaixo
        int i1 = 1;
        Integer i2 = 1;
        Assert.assertEquals(Integer.valueOf(i1), i2);
        Assert.assertEquals(i1, i2.intValue());

        //Exemplo de assertiva com String
        Assert.assertEquals("bola", "bola");

        //Porém para comparar o texto completo como por exemplo maiusculo, é necessario utilizar o assertTrue com os metodos de validação especificos para String conforme exemplos abaixo
        Assert.assertTrue("bola".equalsIgnoreCase("Bola")); //Ignorando a letra maiuscula
        Assert.assertTrue("bola".startsWith("bo")); //Começa com (" ")

        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");
        //No cenario abaixo a validação foi possivel através do metodo Equals implementado através da anotação @Data do lombok na classe Usuario
        //O objeto é o responsavel por realizar a comparação, caso não existe um metodo equals implementado na classe é utilizado a classe Object,
        // que realiza a comparação dos valores de memoria de cada
        //objeto instanciado que no caso será diferente.
        Assert.assertEquals(u1, u2);

//
        //Realiza a comparação das instancias.
        Assert.assertSame(u1, u1);

        //TODO entender melhor
        //Existe tbm os metodos de assertiva negativa
        Assert.assertThat(u1, CoreMatchers.is(CoreMatchers.not(u2)));


    }
}
