package com.selenium.basic.TestNG;

import org.testng.annotations.Test;

public class GroupsDemo {
  @Test(groups = {"maruthi", "cars"})          // to display cars that are members of maruthi groups, run the class as Run Configuration, select the groups radio button and browse and select maruthi chekbox
  public void swift () {
  }
  
  @Test(groups = {"maruthi", "cars"})
  public void ertiga() {
  }
  
  @Test(groups = "mahendra")
  public void xuv500() {
  }
  
  @Test(groups = "mahendra")
  public void xuv300() {
  }
  
  @Test(groups = "audi")
  public void Q1() {
  }
  
  @Test(groups = {"audi", "cars"})
  public void Q6() {
  }
  
  @Test(groups = "audi")
  public void Q2(){
  }
  
  
  @Test(groups = "bmw")
  public void X1(){
  }
  
  @Test(groups = "bmw")
  public void X6(){
  }
}
