package sneaky.bigb.gui;

import sneaky.bigb.helpers.LogHelper;

/**
 * @author SneakyTactician
 * Holds some logic and data that helps the GUI render things right for various screen resolutions.
 */
public class ScreenResolutionHandler
{
	/**
	 * Helps the access unit to draw the player inventory hotbar correctly.
	 */
	public static int GetYValueForAccessUnitContainerHotBars()
	{
    	double b = 480;
    	double c = 3.45;
    	double a = b / c;
    	int d = (int) Math.round(a);
    	
    	return ((GUIUtils.GetSHeight() / 80) + (d) + 22);
	}
}