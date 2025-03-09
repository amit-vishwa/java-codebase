package com.learnjava.completablefuture;

import com.learnjava.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompletableFutureHelloWorldExceptionTest {

    @Mock
    HelloWorldService helloWorldService = mock(HelloWorldService.class);

    @InjectMocks
    CompletableFutureHelloWorldException completableFutureHelloWorldException;

    @Test
    void withoutExceptions() {
        // given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();
        // when
        String result = completableFutureHelloWorldException.combineThreeCompletableHandle();
        // then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", result);
    }

    @Test
    void handleHello() {
        // given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Got exception for hello."));
        when(helloWorldService.world()).thenCallRealMethod();
        // when
        String result = completableFutureHelloWorldException.combineThreeCompletableHandle();
        // then
        assertEquals(" WORLD! HI COMPLETABLEFUTURE!", result);
    }

    @Test
    void handleHelloWorld() {
        // given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Got exception for hello."));
        when(helloWorldService.world()).thenThrow(new RuntimeException("Got exception for world."));
        // when
        String result = completableFutureHelloWorldException.combineThreeCompletableHandle();
        // then
        assertEquals(" HI COMPLETABLEFUTURE!", result);
    }

    @Test
    void exceptionallyHelloWorldSuccess() {
        // given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();
        // when
        String result = completableFutureHelloWorldException.combineThreeCompletableExceptionally();
        // then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", result);
    }

    @Test
    void exceptionallyHelloWorldFailure() {
        // given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Got exception for hello."));
        when(helloWorldService.world()).thenThrow(new RuntimeException("Got exception for world."));
        // when
        String result = completableFutureHelloWorldException.combineThreeCompletableExceptionally();
        // then
        assertEquals(" HI COMPLETABLEFUTURE!", result);
    }

    @Test
    void whenCompleteHelloWorldSuccess() {
        // given
        when(helloWorldService.hello()).thenCallRealMethod();
        when(helloWorldService.world()).thenCallRealMethod();
        // when
        String result = completableFutureHelloWorldException.combineThreeCompletableWhenComplete();
        // then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!", result);
    }

    @Test
    void whenCompleteHelloWorldFailure() {
        // given
        when(helloWorldService.hello()).thenThrow(new RuntimeException("Got exception for hello."));
        when(helloWorldService.world()).thenThrow(new RuntimeException("Got exception for world."));
        // when
        String result = completableFutureHelloWorldException.combineThreeCompletableWhenComplete();
        // then
        assertEquals(" HI COMPLETABLEFUTURE!", result);
    }

}