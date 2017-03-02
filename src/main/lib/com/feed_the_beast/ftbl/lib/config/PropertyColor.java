package com.feed_the_beast.ftbl.lib.config;

import com.feed_the_beast.ftbl.api.config.IConfigKey;
import com.feed_the_beast.ftbl.api.config.IConfigValue;
import com.feed_the_beast.ftbl.api.config.IGuiEditConfig;
import com.feed_the_beast.ftbl.api.gui.IMouseButton;
import com.feed_the_beast.ftbl.lib.util.LMColorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;

import javax.annotation.Nullable;

/**
 * Created by LatvianModder on 26.08.2016.
 */
public class PropertyColor extends PropertyBase
{
    public static final String ID = "color";

    private int value;

    public PropertyColor()
    {
    }

    public PropertyColor(int v)
    {
        value = v;
    }

    @Override
    public String getName()
    {
        return ID;
    }

    public int getColorValue()
    {
        return value;
    }

    public void setColorValue(int v)
    {
        value = v;
    }

    @Nullable
    @Override
    public Object getValue()
    {
        return getColorValue();
    }

    @Override
    public String getString()
    {
        return LMColorUtils.getHex(getColorValue());
    }

    @Override
    public boolean getBoolean()
    {
        return getColorValue() != 0;
    }

    @Override
    public int getInt()
    {
        return getColorValue();
    }

    @Override
    public IConfigValue copy()
    {
        return new PropertyColor(getColorValue());
    }

    @Override
    public int getColor()
    {
        return 0xFF000000 | getColorValue();
    }

    @Override
    public void onClicked(IGuiEditConfig gui, IConfigKey key, IMouseButton button)
    {
        /*
        GuiSelectors.selectColor(this, (val, set) ->
        {
            if(set)
            {
                setColorValue(val.getInt());
                gui.onChanged(key, getSerializableElement());
            }

            gui.openGui();
        });
        */
    }

    @Override
    public NBTBase serializeNBT()
    {
        return new NBTTagInt(getInt());
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        setColorValue(((NBTPrimitive) nbt).getInt());
    }

    @Override
    public void fromJson(JsonElement json)
    {
        setColorValue(json.getAsInt());
    }

    @Override
    public JsonElement getSerializableElement()
    {
        return new JsonPrimitive(getInt());
    }

    @Override
    public void writeData(ByteBuf data)
    {
        data.writeInt(getInt());
    }

    @Override
    public void readData(ByteBuf data)
    {
        setColorValue(data.readInt());
    }
}