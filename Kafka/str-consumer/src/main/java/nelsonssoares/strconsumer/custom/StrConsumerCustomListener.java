package nelsonssoares.strconsumer.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/*
    ANNOTATION CUSTOMIZADA PARA SIMPLIFICAR A CRIAÇÃO DE LISTENERS
    PARA CONSUMIR MENSAGENS DE UM TOPICO ESPECIFICO.
    PARA UTILIZAR ESSA ANNOTATION, BASTA ANOTAR UM METODO COM @StrConsumerCustomListener,
    E DEFINIR O TOPICO QUE SERÁ CONSUMIDO, ATRAVÉS DO ATRIBUTO "topics" NESTA ANOTAÇÃO.
    ESTA ANOTAÇÃO UTILIZA A ANOTAÇÃO @KafkaListener, PORTANTO, TODOS OS ATRIBUTOS
    DA ANOTAÇÃO @KafkaListener PODEM SER UTILIZADOS.
    ESTES VALORES SAO ATRIBIDOS EM TEMPO DE EXECUÇÃO.

 */

@Retention(RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface StrConsumerCustomListener {

    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "str-topic";

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";

}
