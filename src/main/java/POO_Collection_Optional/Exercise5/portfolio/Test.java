package POO_Collection_Optional.Exercise5.portfolio;

import java.util.LinkedList;
import java.util.List;

public class Test {

    static void main(String[] args) {

        Investment investment1 = new Investment("Hamster", 4, 200.0);
        Investment investment2 = new Investment("XEmpire", 2, 700.0);
        Investment investment3 = new Investment("Dog", 4, 340.0);
        List<Investment> investments = new LinkedList<Investment>();
        investments.add(investment1);
        investments.add(investment3);

        Portfolio myPortfolio = new Portfolio (investments);
        myPortfolio.addNewInvestment(investment2);
        myPortfolio.deleteAnInvestment(investment1);
        myPortfolio.displayAllInvestments();

        System.out.println("\nThe highest investment price is : " + myPortfolio.getHighestInvestmentPrice().orElse(0.0) + "$");
        System.out.println("Hamster " + investment1.getQuantity() + " investments produced : " + investment1.getTotalValue() + "$");
    }
}
