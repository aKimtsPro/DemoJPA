package bstorm.akimts.demo_jpa.config;

import bstorm.akimts.demo_jpa.Boite;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
import java.util.function.Predicate;

@Configuration
public class BeanConfig {

    // Il peut être pratique d'utiliser @Bean dans le cas ou on veut
    // créer un Bean d'une classe qu'on ne défini pas soit même
    //@Bean
    public Scanner sc(){
        return new Scanner(System.in);
    }

    // Dans le cas où on souhait eun bean d'un classe générique
    //@Bean
    public Boite<String> boite(){
        return new Boite<>();
    }

//    @Bean
    public Predicate<Integer> isEven(){
        return integer -> integer % 2 == 0;
    }

}
