package micdoodle8.mods.crossbowmod.network;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import micdoodle8.mods.crossbowmod.CrossbowModServer;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PacketSimple implements IPacket
{
    public static enum EnumSimplePacket
    {
        // SERVER
        S_SHOOT_SERVER(Side.SERVER, Boolean.class),
        // CLIENT
        ;

        private Side targetSide;
        private Class<?>[] decodeAs;

        private EnumSimplePacket(Side targetSide, Class<?>... decodeAs)
        {
            this.targetSide = targetSide;
            this.decodeAs = decodeAs;
        }

        public Side getTargetSide()
        {
            return this.targetSide;
        }

        public Class<?>[] getDecodeClasses()
        {
            return this.decodeAs;
        }
    }

    private EnumSimplePacket type;
    private List<Object> data;
    static private String spamCheckString;

    public PacketSimple()
    {
    }

    public PacketSimple(EnumSimplePacket packetType, Object[] data)
    {
        this(packetType, Arrays.asList(data));
    }

    public PacketSimple(EnumSimplePacket packetType, List<Object> data)
    {
        if (packetType.getDecodeClasses().length != data.size())
        {
            FMLLog.info("Simple Packet found data length different than packet type");
            new RuntimeException().printStackTrace();
        }

        this.type = packetType;
        this.data = data;
    }

    @Override
    public void encodeInto(ChannelHandlerContext context, ByteBuf buffer)
    {
        buffer.writeInt(this.type.ordinal());

        try
        {
            NetworkUtil.encodeData(buffer, this.data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void decodeInto(ChannelHandlerContext context, ByteBuf buffer)
    {
        this.type = EnumSimplePacket.values()[buffer.readInt()];

        try
        {
            if (this.type.getDecodeClasses().length > 0)
            {
                this.data = NetworkUtil.decodeData(this.type.getDecodeClasses(), buffer);
            }
            if (buffer.readableBytes() > 0)
            {
                FMLLog.severe("Crossbow mod packet length problem for packet type " + this.type.toString());
            }
        }
        catch (Exception e)
        {
            System.err.println("[Crossbow mod] Error handling simple packet type: " + this.type.toString() + " " + buffer.toString());
            e.printStackTrace();
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void handleClientSide(EntityPlayer player)
    {
        switch (this.type)
        {
        default:
            break;
        }
    }

    @Override
    public void handleServerSide(EntityPlayer player)
    {
        switch (this.type)
        {
        case S_SHOOT_SERVER:
            CrossbowModServer.shootServer(player, (Boolean) data.get(0));
            break;
        default:
            break;
        }
    }
}
