package main.najah.test;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Recipe Book Tests")
public class RecipeBookTest {

    RecipeBook book;
    Recipe recipe;

    @BeforeEach
    void setup() {
        book = new RecipeBook();
        recipe = new Recipe();
        recipe.setName("Coffee");
    }

    @Test
    @DisplayName("Add Recipe")
    void testAddRecipe() {
        assertTrue(book.addRecipe(recipe));
    }

    @Test
    @DisplayName("Duplicate Recipe Should Not Be Added")
    void testDuplicateRecipe() {
        book.addRecipe(recipe);
        assertFalse(book.addRecipe(recipe));
    }

    @Test
    @DisplayName("Delete Recipe")
    void testDeleteRecipe() {
        book.addRecipe(recipe);
        assertNotNull(book.deleteRecipe(0));
    }

    @Test
    @DisplayName("Edit Recipe")
    void testEditRecipe() {
        book.addRecipe(recipe);
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Espresso");
        assertEquals("Coffee", book.editRecipe(0, newRecipe));
    }
}
