package com.designapi;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTestes {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito(){

        Mockito.when(lista.size()).thenReturn(20);

        int size = lista.size();

        Assertions.assertThat(size).isEqualTo(20);

        Mockito.verify(lista, Mockito.times(1)).size();
    }




}
