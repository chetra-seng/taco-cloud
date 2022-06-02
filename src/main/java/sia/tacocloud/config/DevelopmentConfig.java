package sia.tacocloud.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.model.Ingredient;
import sia.tacocloud.model.User;
import sia.tacocloud.repository.IngredientRepository;
import sia.tacocloud.model.Ingredient.*;
import sia.tacocloud.repository.UserRepository;

/**
 * Created by chetra_seng on 2/6/22
 */
@Profile("dev")
@Configuration
public class DevelopmentConfig {
    @Bean
    public CommandLineRunner dataLoader(
            IngredientRepository ingredientRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

                userRepository.save(new User("chetra", passwordEncoder.encode("password"),
                        "Chetra Seng", "143", "Battambang", "Battambang", "12345", "092823836"));
            }
        };
    }
}
