package com.anthony;

import com.anthony.card.Card;
import com.anthony.card.Rank;
import com.anthony.card.Suit;
import com.anthony.user.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player testPlayer = new Player("testPlayer");
    Card testCard1 = new Card(Suit.Diamond, Rank.Ace);
    Card testCard2 = new Card(Suit.Club, Rank.Ace);

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("Starting..." + testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("Ending..." + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Add card to hand")
    void Add_card_to_hand() {
        testPlayer.addCard(testCard1);
        int expected_handSize = 1;
        int actual_handSize = testPlayer.getHand().size();
        assertEquals(expected_handSize,actual_handSize);
    }

    @Test
    @DisplayName("Adjust hand value for ace and over 21")
    void Adjust_hand_for_ace_and_over_21(){
        testPlayer.addCard(testCard1);
        testPlayer.addCard(testCard2);
        int expected_handValue = 12;
        int actual_handValue = testPlayer.getHandValue();
        assertEquals(expected_handValue,actual_handValue);
    }
}