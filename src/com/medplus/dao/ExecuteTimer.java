package com.medplus.dao;
import java.util.Timer;
import java.io.IOException;



import java.util.TimerTask;
public class ExecuteTimer {
  public static void main(String[] args){
	  
	  
       TimerTask te1=new TimerExample("Task1");
       TimerExample te2=new TimerExample("Task2");
      Timer t=new Timer();
      t.scheduleAtFixedRate(te1, 0,10*60*1000);
     //t.scheduleAtFixedRate(te2, 0,1000);
	  }
	  
}




