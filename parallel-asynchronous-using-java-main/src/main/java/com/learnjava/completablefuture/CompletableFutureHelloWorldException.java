package com.learnjava.completablefuture;

import com.learnjava.service.HelloWorldService;

import java.util.concurrent.CompletableFuture;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.CommonUtil.timeTaken;
import static com.learnjava.util.LoggerUtil.log;

public class CompletableFutureHelloWorldException {

    public HelloWorldService hws;

    public CompletableFutureHelloWorldException(HelloWorldService hws){
        this.hws = hws;
    }

    /**
     * handle() is invoked in both failure and success case.
     * It takes BiFunction as an argument
     * */
    public String combineThreeCompletableHandle(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });
        String response = hcf
                .handle((res, ex)->{
                    log("Result: " + res);
                    if(ex != null){
                        log(ex.getMessage());
                        return "";
                    }
                    return res;
                }) // ""
                .thenCombine(wcf, String::concat)
                .handle((res, ex)->{
                    log("Result: " + res);
                    if(ex != null){
                        log(ex.getMessage());
                        return "";
                    }
                    return res;
                }) // ""
                // " Hi CompletableFuture!"
                .thenCombine(hicf,(prev,curr)-> prev.concat(curr))
                .thenApply(String::toUpperCase) // " WORLD! HI COMPLETABLEFUTURE!"
                .join(); // " WORLD! HI COMPLETABLEFUTURE!"
        timeTaken();
        return response;
    }

    /**
     * exceptionally() is invoked only in failure case.
     * It takes Function as an argument
     * */
    public String combineThreeCompletableExceptionally(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });
        String response = hcf
                .exceptionally((ex)->{
                    log(ex.getMessage());
                    return "";
                }) // ""
                .thenCombine(wcf, String::concat)
                .exceptionally((ex)->{
                    log(ex.getMessage());
                    return "";
                }) // ""
                // " Hi CompletableFuture!"
                .thenCombine(hicf, String::concat)
                .thenApply(String::toUpperCase) // " WORLD! HI COMPLETABLEFUTURE!"
                .join(); // " WORLD! HI COMPLETABLEFUTURE!"
        timeTaken();
        return response;
    }

    /**
     * whenComplete() is invoked in both success and failure case.
     * It takes BiConsumer as an argument.
     * Exceptions propagate to next handler.
     * */
    public String combineThreeCompletableWhenComplete(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });
        String response = hcf
                // exception will propagate to next handler whenComplete
                .whenComplete((res,ex)->{
                    log("Result: " + res);
                    if(ex != null){
                        log(ex.getMessage());
                    }
                }) // ""
                .thenCombine(wcf, String::concat)
                // exception will propagate to next handler exceptionally
                .whenComplete((res,ex)->{
                    log("Result: " + res);
                    if(ex != null){
                        log(ex.getMessage());
                    }
                }) // ""
                // below handler added to handle above propagated exceptions
                .exceptionally(e->{
                    log(e.getMessage());
                    return "";
                })
                // " Hi CompletableFuture!"
                .thenCombine(hicf, String::concat)
                .thenApply(String::toUpperCase) // " WORLD! HI COMPLETABLEFUTURE!"
                .join(); // " WORLD! HI COMPLETABLEFUTURE!"
        timeTaken();
        return response;
    }

}
