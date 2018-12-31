package org.ocea3.lightApp;

public class LedLight implements ISwitch
{
	@Override
	public void sOn() 
	{
	System.out.println("ledlight turned on");
		
	}

	@Override
	public void sOff() 
	{
	System.out.println("ledlight turned off");	
		
	}

}
