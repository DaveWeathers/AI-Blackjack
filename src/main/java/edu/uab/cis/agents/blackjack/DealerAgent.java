package edu.uab.cis.agents.blackjack;

import java.util.List;

/**
 * A dealer takes the {@link Action#HIT} action until their cards total 17 or
 * more points. Then the dealer takes the {@link Action#STAND} action.
 */
public class DealerAgent implements Agent {
private int count;
private int ace;

  @Override
  public Action act(List<Card> cards) {
    count(cards);
    return decide();


    //throw new UnsupportedOperationException();
  }

  private void count(List<Card> cards){
    count = 0;
    ace = 0;
	for(int i = 0; i < cards.size(); i++){
		switch(cards.get(i).getRank()){
            case ACE:
                count += 11;
                ace += 1;
                break;
            case TWO:
                count += 2;
                break;
            case THREE:
                count += 3;
                break;
            case FOUR:
                count += 4;
                break;
            case FIVE:
                count += 5;
                break;
            case SIX:
                count += 6;
                break;
            case SEVEN:
                count += 7;
                break;
            case EIGHT:
                count += 8;
                break;
            case NINE:
                count += 9;
                break;
            default:
                count += 10;
		}
	}
	return;
}
private Action decide(){

  if(count < 17){
        return Action.HIT;
    } else if (count > 16 && count < 22){
        return Action.STAND;
    } else {
        if(ace > 0){
        ace = ace - 1;
        count = count - 10;
        return decide();
        } else {
            return Action.BUST;
        }
    }
    }
}
