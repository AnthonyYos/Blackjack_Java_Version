import com.anthony.Card;
import com.anthony.Player;
import com.anthony.Rank;
import com.anthony.Suit;
import org.junit.jupiter.api.*;

public class PlayerTest {
    Player testPlayer = new Player();

    @BeforeAll
    static void initAll(TestInfo testInfo){
        System.out.println("Starting PlayerTest");
    }

    @BeforeEach
    void init(TestInfo testInfo){
        System.out.println("Start..." + testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo){
        System.out.println("End..." + testInfo.getDisplayName());
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("PlayerTest Finished");
    }

    @Test
    @DisplayName("Add to Hand Test")
    void add_Card_to_hand() {
        Card testCard = new Card(Suit.Club, Rank.Ace);
        testPlayer.addCard(testCard);
        int expected_handSize = 1;
        Assertions.assertEquals(expected_handSize, testPlayer.getHand().size(), "hand size will be 1");
    }

    @Test
    @DisplayName("Adjust Hand Value for Ace")
    void adjustHandvalueOver21AndAcePresent() {
        Card testCard = new Card(Suit.Club, Rank.Ace);
        testPlayer.addCard(testCard);
        testCard = new Card(Suit.Diamond, Rank.Ace);
        testPlayer.addCard(testCard);
        int expected_handValue = 12;
        Assertions.assertEquals(expected_handValue, testPlayer.getHandValue(), "hand value will be 12");
    }
}
