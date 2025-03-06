package com.learnjava.completablefuture;

import com.learnjava.service.HelloWorldService;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static com.learnjava.util.CommonUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class CompletableFutureHelloWorldTest {

    HelloWorldService hws = new HelloWorldService();
    CompletableFutureHelloWorld cfhw = new CompletableFutureHelloWorld(hws);

    @Test
    void helloWorld() {
        // given
        // when
        CompletableFuture<String> completableFuture = cfhw.helloWorld();
        // then
        completableFuture.thenAccept(result->assertEquals("HELLO WORLD",result))
                .join(); // join is used to wait for completion of worker thread
    }

    @Test
    void helloWorld_withSize() {
        // given
        // when
        CompletableFuture<String> completableFuture = cfhw.helloWorld_withSize();
        // then
        completableFuture.thenAccept(result->assertEquals("11 - HELLO WORLD",result))
                .join(); // join is used to wait for completion of worker thread
    }

    @Test
    void helloWorldSync() {
        // given
        // when
        String string = cfhw.helloWordSync();
        // then
        assertEquals("HELLO WORLD!",string);
    }

    @Test
    void helloWorldAsync() {
        // given
        // when
        String string = cfhw.helloWordAsync();
        // then
        assertEquals("HELLO WORLD!",string);
    }

    @Test
    void combineThreeCompletable() {
        // given
        // when
        String string = cfhw.combineThreeCompletable();
        // then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE!",string);
    }

    @Test
    void combineFourCompletable() {
        // given
        // when
        String string = cfhw.helloWorld_4_async_calls();
        // then
        assertEquals("HELLO WORLD! HI COMPLETABLEFUTURE! BYE!",string);
    }

    @Test
    void helloWorld_thenCompose() {
        // given
        // when
        stopWatchReset();
        startTimer();
        CompletableFuture<String> completableFuture = cfhw.helloWorld_thenCompose();
        // then
        completableFuture.thenAccept(result->assertEquals("HELLO WORLD!",result))
                .join(); // join is used to wait for completion of worker thread
        timeTaken();
    }

}