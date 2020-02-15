package com.r.design.creational.builder;

import com.r.design.creational.builder.generic.Builder;
import com.r.design.creational.builder.model.*;
import org.junit.Test;

import static com.r.design.creational.builder.FluentPizzaBuilder.aPizza;
import static com.r.design.creational.builder.generic.Builder.a;

public class FluentPizzaBuilderTest {

  @Test
  public void testBuild() {

    Pizza pizza =
        aPizza()
            .withCrust(Crust.THIN)
            .withDough(Dough.WHEAT)
            .withPizzaSize(PizzaSize.PAN)
            .withTopping(new BeaconTopping())
            .withTopping(new CheeseTopping())
            .build();
      System.out.println(pizza);
  }

  @Test
    public void testGenericBuilder(){
      Pizza pizza=a(new Pizza()).with(Pizza::setCrust, Crust.THIN).with(Pizza::setSize, PizzaSize.SMALL).build();
    System.out.println(pizza);
  }
}
