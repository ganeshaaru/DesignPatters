package com.r.design.creational.builder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Pizza {
  private Dough dough;
  private Crust crust;
  private List<Topping> toppings;
  private PizzaSize size;

  public Pizza() {
   this.toppings = new ArrayList<>();
  }

  public Dough getDough() {
    return dough;
  }

  public void setDough(Dough dough) {
    this.dough = dough;
  }

  public Crust getCrust() {
    return crust;
  }

  public void setCrust(Crust crust) {
    this.crust = crust;
  }

  public void addTopping(Topping topping) {
     toppings.add(topping);
  }

  public PizzaSize getSize() {
    return size;
  }

  public void setSize(PizzaSize size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Pizza.class.getSimpleName() + "[", "]")
            .add("dough=" + dough)
            .add("crust=" + crust)
            .add("toppings=" + toppings)
            .add("size=" + size)
            .toString();
  }
}
