package org.ocea3.lightApp;

public class LightFactory 
{
public static ISwitch getlight(String type)
{
	if(type.equalsIgnoreCase("tubelight"))
	{
		return new TubelightImpl();
	}
	else if(type.equalsIgnoreCase("ledlight")) 
	{
		return new LedLight();
	}
	else
	{
		System.err.println("no light found");
	}
	return null;
}
}
