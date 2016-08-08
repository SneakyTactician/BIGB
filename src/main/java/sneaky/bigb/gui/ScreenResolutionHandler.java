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
		LogHelper.ErrorAlways("Screen Height = " + GUIUtils.GetSHeight());
		
		//Heights to support: 1387, 1080, 1200, 1440, 480
		
		switch (GUIUtils.GetSHeight())
		{
		case 480:
			return 167;
		case 1080:
			return 0;
		case 1200:
			return 0;
		case 1387:
			return 0;
		case 1440:
			return 0;
			default:
				return (GUIUtils.GetSHeight() / 3) + GUIUtils.GetSHeight() / 50;
		}
	}
}