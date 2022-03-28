import com.anthony.Card;
import com.anthony.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTest {
    Deck testDeck = new Deck();

    @Test
    void deal_returnsACard(){
        Card testCard = testDeck.deal();
        Assertions.assertTrue(testCard instanceof Card);
    }
}
