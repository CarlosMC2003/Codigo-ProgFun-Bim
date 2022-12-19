//Flujo De datos
//Clase de Java: App.java

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class App {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        //Crear el Suscriber y subscription
        PrinterSubscriber printerSubscriber = new PrinterSubscriber();

        //Subscripci[on
        publisher.subscribe(printerSubscriber);

        List<String> items = List.of("1", "x", "2", "x", "3", "x");
        //Enviar los datos a los suscritores
        items.forEach(publisher::submit);

        Thread.sleep(1 * 1000);

        publisher.close();
    }
}

//Clase de Java: PrinterSubscriber.java

import java.util.concurrent.Flow;

public class PrinterSubscriber implements Flow.Subscriber <String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Suscrito");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.printf("Valor: %s\n", item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Todo Procesado!");
    }
}

//Ejemplo 2
//Clase de Java: TransformProcessor.java

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class TransformProcessor extends SubmissionPublisher<String> 
        implements Flow.Processor<String, String> {
    private Flow.Subscription subscription;
    private Function<String, String> function;

    public TransformProcessor(Function<String, String> function) {
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        submit(function.apply(item));
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() { close(); }
}

//Clase de Java: App.java
import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        //Crear el Suscriber y subscription
        PrinterSubscriber printerSubscriber = new PrinterSubscriber();

        //Función
        Function<String, String> toUpper = String::toUpperCase;

        //Crear Processor
        TransformProcessor transformProcessor = new TransformProcessor(toUpper);

        //Subscripci[on
        publisher.subscribe(transformProcessor);
        transformProcessor.subscribe(printerSubscriber);

        List<String> items = List.of("juan", "pedro", "mayra", "ana", "ariel", "diego");
        //Enviar los datos a los suscritores
        items.forEach(publisher::submit);

        Thread.sleep(1 * 1000);

        publisher.close();
    }
}
