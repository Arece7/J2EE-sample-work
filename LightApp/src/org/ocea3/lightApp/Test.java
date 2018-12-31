package org.ocea3.lightApp;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) 
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("please enter the type of light");
		String type=scn.next();
		scn.close();//costlier resources should be closed
       ISwitch sw=LightFactory.getlight(type);
       if(sw!=null)
       {
    	   sw.sOn();
    	   sw.sOff();
       }
	}

}
