package com.learnjava.completablefuture;

import com.learnjava.service.HelloWorldService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;

public class CompletableFutureHelloWorld {

    public HelloWorldService hws;

    public CompletableFutureHelloWorld(HelloWorldService hws){
        this.hws = hws;
    }

    public CompletableFuture<String> helloWorld(){
        return CompletableFuture.supplyAsync(hws::helloWorld)
                .thenApply(String::toUpperCase);
    }

    public CompletableFuture<String> helloWorld_withSize(){
        return helloWorld()
                .thenApply(string -> string.length() + " - " + string);
    }

    public String helloWordSync(){
        stopWatchReset();
        startTimer();
        String hello = hws.hello();
        String world = hws.world();
        timeTaken();
        return hello.concat(world).toUpperCase();
    }

    public String helloWordAsync(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        String response = hcf
                .thenCombine(wcf, String::concat) // used method ref instead of below
//                .thenCombine(wcf,(h,w)->h.concat(w))
                .thenApply(String::toUpperCase)
                .join();
        timeTaken();
        return response;
    }

    public String combineThreeCompletable(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });
        String response = hcf
                .thenCombine(wcf, String::concat) // used method ref instead of below
                .thenCombine(hicf,(prev,curr)-> prev.concat(curr))
                .thenApply(String::toUpperCase)
                .join();
        timeTaken();
        return response;
    }

    // Uses commonPool from ForkJoinPool for thread execution
    public String combineThreeCompletable_Log(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });
        String response = hcf
                .thenCombine(wcf, (h,w) -> {
                    log("inside thenCombine of hello for world");
                    return h.concat(w);
                })
                .thenCombine(hicf,(prev,curr) -> {
                    log("inside thenCombine of hi for helloworld");
                    return prev.concat(curr);
                })
                .thenApply(res -> {
                    log("inside thenApply of hi for hicompletablefuturehelloworld");
                    return res.toUpperCase();
                })
                .join();
        timeTaken();
        return response;
    }

    // Uses thread pool for thread execution
    public String combineThreeCompletable_customThreadPool(){
        stopWatchReset();
        startTimer();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors());
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello,executorService);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world,executorService);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        },executorService);
        String response = hcf
                .thenCombine(wcf, (h,w) -> {
                    log("inside thenCombine of hello for world");
                    return h.concat(w);
                })
                .thenCombine(hicf,(prev,curr) -> {
                    log("inside thenCombine of hi for helloworld");
                    return prev.concat(curr);
                })
                .thenApply(res -> {
                    log("inside thenApply of hi for hicompletablefuturehelloworld");
                    return res.toUpperCase();
                })
                .join();
        timeTaken();
        return response;
    }

    // Assigns different threads to execute tasks
    public String combineThreeCompletable_LogAsync(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });
        String response = hcf
                .thenCombineAsync(wcf, (h,w) -> {
                    log("inside thenCombine of hello for world");
                    return h.concat(w);
                })
                .thenCombineAsync(hicf,(prev,curr) -> {
                    log("inside thenCombine of hi for helloworld");
                    return prev.concat(curr);
                })
                .thenApplyAsync(res -> {
                    log("inside thenApply of hi for hicompletablefuturehelloworld");
                    return res.toUpperCase();
                })
                .join();
        timeTaken();
        return response;
    }

    /**
     * Assigns different threads to execute each task
     * */
    public String combineThreeCompletable_customThreadPoolAsync(){
        stopWatchReset();
        startTimer();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
                .availableProcessors());
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello,executorService);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world,executorService);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        },executorService);
        String response = hcf
                .thenCombineAsync(wcf, (h,w) -> {
                    log("inside thenCombine of hello for world");
                    return h.concat(w);
                }, executorService)
                .thenCombineAsync(hicf,(prev,curr) -> {
                    log("inside thenCombine of hi for helloworld");
                    return prev.concat(curr);
                }, executorService)
                .thenApplyAsync(res -> {
                    log("inside thenApply of hi for hicompletablefuturehelloworld");
                    return res.toUpperCase();
                },executorService)
                .join();
        timeTaken();
        return response;
    }

    public String helloWorld_4_async_calls(){
        stopWatchReset();
        startTimer();
        CompletableFuture<String> hcf = CompletableFuture.supplyAsync(hws::hello);
        CompletableFuture<String> wcf = CompletableFuture.supplyAsync(hws::world);
        CompletableFuture<String> hicf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Hi CompletableFuture!";
        });
        CompletableFuture<String> bcf = CompletableFuture.supplyAsync(()->{
            delay(1000);
            return " Bye!";
        });
        String response = hcf
                .thenCombine(wcf, String::concat) // used method ref instead of below
                .thenCombine(hicf,(prev,curr)-> prev.concat(curr))
                .thenCombine(bcf,String::concat)
                .thenApply(String::toUpperCase)
                .join();
        timeTaken();
        return response;
    }

    public CompletableFuture<String> helloWorld_thenCompose(){
        return CompletableFuture.supplyAsync(hws::hello)
                // thenCompose waits for previous task hence delay will happen
                .thenCompose(prev->hws.worldFuture(prev))
                .thenApply(String::toUpperCase);
    }

    public static void main(String[] args) {
        HelloWorldService hws = new HelloWorldService();

        // Pipeline - chaining in CompletableFuture
        /*CompletableFuture
                .supplyAsync(hws::helloWorld)
                .thenApply(String::toUpperCase)
                .thenAccept(System.out::println)
                .join();*/

        // supplyAsync() takes Supplier Functional Interface as an argument
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(hws::helloWorld);
        // thenApply() takes Function Functional Interface as an argument
        CompletableFuture<String> completableFutureFunction = completableFuture.thenApply(String::toUpperCase);
        // by default main thread will complete before async tasks from CompletableFuture
        // it releases calling thread if join is not used here
        completableFutureFunction
                // thenAccept() takes Consumer Functional Interface as an argument
                .thenAccept(result -> log("Result: " + result))
                .join(); // blocks main (current function) thread to proceed further

        log("Done!");
//        delay(2000); // main thread can be blocked to show async response
    }

}
