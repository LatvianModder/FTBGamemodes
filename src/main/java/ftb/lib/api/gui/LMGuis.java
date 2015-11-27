package ftb.lib.api.gui;

import ftb.lib.api.gui.callback.*;
import ftb.lib.client.FTBLibClient;
import ftb.lib.mod.client.FTBLibModClient;
import ftb.lib.mod.client.gui.*;

public class LMGuis
{
	public static void displayColorSelector(IColorCallback cb, int col, int id, boolean instant)
	{
		if(FTBLibModClient.openHSB.get())
			FTBLibClient.mc.displayGuiScreen(new GuiSelectColorHSB(cb, col, id, instant));
		else FTBLibClient.mc.displayGuiScreen(new GuiSelectColorRGB(cb, col, id, instant));
	}
	
	public static void displayFieldSelector(Object id, FieldType typ, Object d, IFieldCallback c)
	{ FTBLibClient.mc.displayGuiScreen(new GuiSelectField(id, typ, String.valueOf(d), c)); }
}