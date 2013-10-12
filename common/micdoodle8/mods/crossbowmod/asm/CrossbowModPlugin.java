package micdoodle8.mods.crossbowmod.asm;

import java.awt.Desktop;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@TransformerExclusions(value = { "micdoodle8.mods.crossbowmod.asm" })
public class CrossbowModPlugin implements IFMLLoadingPlugin, IFMLCallHook
{
    private static String transformerDir = "micdoodle8.mods.crossbowmod.asm.";
    private static String transformerMain = CrossbowModPlugin.transformerDir + "CrossbowModTransformer";
    public static boolean hasRegistered = false;
    public static final String mcVersion = "[1.6.4]";
    public static File mcDir;

    @Override
    public String[] getLibraryRequestClass()
    {
        return null;
    }

    public static void versionCheck(String reqVersion, String mod)
    {
        final String mcVersion = (String) FMLInjectionData.data()[4];

        if (!VersionParser.parseRange(reqVersion).containsVersion(new DefaultArtifactVersion(mcVersion)))
        {
            final String err = "This version of " + mod + " does not support minecraft version " + mcVersion;
            System.err.println(err);

            final JEditorPane ep = new JEditorPane("text/html", "<html>" + err + "<br>Remove it from your mods folder and check <a href=\"http://micdoodle8.com\">here</a> for updates" + "</html>");

            ep.setEditable(false);
            ep.setOpaque(false);
            ep.addHyperlinkListener(new HyperlinkListener()
            {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent event)
                {
                    try
                    {
                        if (event.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
                        {
                            Desktop.getDesktop().browse(event.getURL().toURI());
                        }
                    }
                    catch (final Exception e)
                    {
                    }
                }
            });

            JOptionPane.showMessageDialog(null, ep, "Fatal error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    @Override
    public String[] getASMTransformerClass()
    {
        CrossbowModPlugin.versionCheck(CrossbowModPlugin.mcVersion, "Crossbow Mod 2");
        final String[] asmStrings = new String[] { CrossbowModPlugin.transformerMain };

        if (!CrossbowModPlugin.hasRegistered)
        {
            final List<String> asm = Arrays.asList(asmStrings);

            for (final String s : asm)
            {
                try
                {
                    final Class<?> c = Class.forName(s);

                    if (c != null)
                    {
                        System.out.println("Successfully Registered Transformer");
                    }
                }
                catch (final Exception ex)
                {
                    System.out.println("Error while running transformer " + s);
                    return null;
                }
            }

            CrossbowModPlugin.hasRegistered = true;
        }

        return asmStrings;
    }

    @Override
    public String getModContainerClass()
    {
        return null;
    }

    @Override
    public String getSetupClass()
    {
        return "micdoodle8.mods.crossbowmod.asm.CrossbowModPlugin";
    }

    @Override
    public void injectData(Map<String, Object> data)
    {
        if (data.containsKey("mcLocation"))
        {
            CrossbowModPlugin.mcDir = (File) data.get("mcLocation");
        }
        System.out.println("[CrossbowModPlugin]: " + "Patching game...");
    }

    @Override
    public Void call() throws Exception
    {
        return null;
    }
}
