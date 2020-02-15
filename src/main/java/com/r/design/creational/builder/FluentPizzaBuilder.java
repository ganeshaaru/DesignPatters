package com.r.design.creational.builder;

import com.r.design.creational.builder.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FluentPizzaBuilder {
  private Dough dough;
  private Crust crust;
  private List<Topping> toppings = new ArrayList<>();
  private PizzaSize size;

  private FluentPizzaBuilder() {}

  public static FluentPizzaBuilder aPizza() {
    return new FluentPizzaBuilder();
  }

  public FluentPizzaBuilder withCrust(Crust crust) {
    this.crust = crust;
    return this;
  }

  public FluentPizzaBuilder withDough(Dough dough) {
    this.dough = dough;
    return this;
  }

  public FluentPizzaBuilder withPizzaSize(PizzaSize size) {
    this.size = size;
    return this;
  }

  public FluentPizzaBuilder withTopping(Topping topping) {
    this.toppings.add(topping);
    return this;
  }

  public Pizza build() {
    Pizza pizza = new Pizza();
    pizza.setCrust(this.crust);
    pizza.setDough(this.dough);
    pizza.setSize(this.size);
    this.toppings.forEach(topping -> pizza.addTopping(topping));
    return pizza;
  }
}
