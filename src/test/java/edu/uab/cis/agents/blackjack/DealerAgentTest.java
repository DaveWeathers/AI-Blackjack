package edu.uab.cis.agents.blackjack;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.uab.cis.agents.blackjack.Action;
import edu.uab.cis.agents.blackjack.Card;
import edu.uab.cis.agents.blackjack.DealerAgent;
import edu.uab.cis.agents.blackjack.Card.Rank;
import edu.uab.cis.agents.blackjack.Card.Suit;

public class DealerAgentTest {

  @Test
  public void testTenKing() {
    DealerAgent agent = new DealerAgent();
    Card s10 = new Card(Rank.TEN, Suit.SPADES);
    Card hK = new Card(Rank.KING, Suit.HEARTS);
    Action action = agent.act(Arrays.asList(s10, hK));
    Assert.assertEquals(Action.STAND, action);
  }

  @Test
  public void testSixJack() {
    DealerAgent agent = new DealerAgent();
    Card d6 = new Card(Rank.SIX, Suit.DIAMONDS);
    Card cJ = new Card(Rank.JACK, Suit.CLUBS);
    Action action = agent.act(Arrays.asList(d6, cJ));
    Assert.assertEquals(Action.HIT, action);
  }
    @Test
  public void testDoubleAces() {
    DealerAgent agent = new DealerAgent();
    Card d6 = new Card(Rank.ACE, Suit.DIAMONDS);
    Card cJ = new Card(Rank.ACE, Suit.CLUBS);
    Action action = agent.act(Arrays.asList(d6, cJ));
    Assert.assertEquals(Action.HIT, action);
  }
      @Test
  public void testKingDoubleAces() {
    DealerAgent agent = new DealerAgent();
    Card d6 = new Card(Rank.ACE, Suit.DIAMONDS);
    Card cJ = new Card(Rank.ACE, Suit.CLUBS);
    Card eK = new Card(Rank.KING, Suit.SPADES);
    Action action = agent.act(Arrays.asList(d6, cJ, eK));
    Assert.assertEquals(Action.HIT, action);
}
    @Test
  public void testKingBust() {
    DealerAgent agent = new DealerAgent();
    Card d6 = new Card(Rank.FIVE, Suit.DIAMONDS);
    Card cJ = new Card(Rank.NINE, Suit.CLUBS);
    Card eK = new Card(Rank.KING, Suit.SPADES);
    Action action = agent.act(Arrays.asList(d6, cJ, eK));
    Assert.assertEquals(Action.BUST, action);
}
     @Test
  public void testKingDoubleAcesBust() {
    DealerAgent agent = new DealerAgent();
    Card d6 = new Card(Rank.ACE, Suit.DIAMONDS);
    Card cJ = new Card(Rank.ACE, Suit.CLUBS);
    Card fO = new Card(Rank.TEN, Suit.CLUBS);
    Card eK = new Card(Rank.KING, Suit.SPADES);
    Action action = agent.act(Arrays.asList(d6, cJ, eK, fO));
    Assert.assertEquals(Action.BUST, action);
}
}
