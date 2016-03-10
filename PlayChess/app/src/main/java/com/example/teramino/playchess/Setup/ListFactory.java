package com.example.teramino.playchess.Setup;

public class ListFactory
{
	private String name;
	private double row;
	private double col;
	
	public ListFactory(String n, double r, double c)
	{
		name = n;
		row = r;
		col = c;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setRow(double r)
	{
		row = r;
	}
	
	public void setCol(double c)
	{
		col = c;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getRow()
	{
		return row;
	}
	
	public double getCol()
	{
		return col;
	}
	
	public String toString()
	{
		return "\n" + getName() + "\n" + getRow()/50 + "\n" + getCol()/50 + "\n";
	}
}
