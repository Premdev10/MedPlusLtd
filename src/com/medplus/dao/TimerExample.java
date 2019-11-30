package com.medplus.dao;
import java.io.IOException;
import java.sql.Date;

import java.util.TimerTask;


class TimerExample extends TimerTask{
	
	private String name ;
	public TimerExample(String n){
	  this.name=n;
	  
	}
	@Override
	public void run() {
		
	EmailSender em= new EmailSender();
	em.sendEmail();
		
         
	    System.out.println(Thread.currentThread().getName()+" "+name+" One minutes ");
	    if("Task1".equalsIgnoreCase(name)){
	      try {
	      Thread.sleep(10000);
	      } catch (InterruptedException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	}
	}
}