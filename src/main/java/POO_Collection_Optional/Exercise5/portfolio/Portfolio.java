package POO_Collection_Optional.Exercise5.portfolio;

import java.util.List;
import java.util.Optional;

public class Portfolio {

    List<Investment> investments;

    public Portfolio(List<Investment> investments) {
        this.investments = investments;
    }

    public Optional<Double> getHighestInvestmentPrice(){

        return investments.stream()
                .map(investment -> investment.getPrice().orElse(0.0))
                .reduce((price1, price2) -> price1 >= price2? price1 : price2);
    }
}
