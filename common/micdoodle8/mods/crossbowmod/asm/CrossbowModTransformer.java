package micdoodle8.mods.crossbowmod.asm;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Iterator;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class CrossbowModTransformer implements net.minecraft.launchwrapper.IClassTransformer
{
    HashMap<String, String> nodemap = new HashMap<String, String>();
    private boolean deobfuscated = true;

    public CrossbowModTransformer()
    {
        try
        {
            final URLClassLoader loader = new LaunchClassLoader(((URLClassLoader) this.getClass().getClassLoader()).getURLs());
            final URL classResource = loader.findResource(String.valueOf("net.minecraft.world.World").replace('.', '/').concat(".class"));
            if (classResource == null)
            {
                this.deobfuscated = false;
            }
            else
            {
                this.deobfuscated = true;
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
        }

        if (this.deobfuscated)
        {
            this.nodemap.put("entityClass", "net/minecraft/entity/Entity");
            this.nodemap.put("modelBipedClass", "net/minecraft/client/model/ModelBiped");
            this.nodemap.put("setRotationAnglesMethod", "setRotationAngles");
            this.nodemap.put("setRotationAnglesDesc", "(FFFFFFL" + this.nodemap.get("entityClass") + ";)V");
        }
        else
        {
            this.nodemap.put("entityClass", "nn");
            this.nodemap.put("modelBipedClass", "bbj");
            this.nodemap.put("setRotationAnglesMethod", "a");
            this.nodemap.put("setRotationAnglesDesc", "(FFFFFFL" + this.nodemap.get("entityClass") + ";)V");
        }
    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        if (name.replace('.', '/').equals(this.nodemap.get("modelBipedClass")))
        {
            bytes = this.transform1(name, bytes, this.nodemap);
        }

        return bytes;
    }

    public byte[] transform1(String name, byte[] bytes, HashMap<String, String> map)
    {
        final ClassNode node = new ClassNode();
        final ClassReader reader = new ClassReader(bytes);
        reader.accept(node, 0);

        int operationCount = 1;
        int injectionCount = 0;

        final Iterator<MethodNode> methods = node.methods.iterator();

        label4123:
        while (methods.hasNext())
        {
            final MethodNode methodnode = methods.next();

            if (methodnode.name.equals(map.get("setRotationAnglesMethod")) && methodnode.desc.equals(map.get("setRotationAnglesDesc")))
            {
                for (int count = 0; count < methodnode.instructions.size(); count++)
                {
                    final AbstractInsnNode insnNode = methodnode.instructions.get(count);

                    if (insnNode instanceof FieldInsnNode && ((FieldInsnNode) insnNode).name.equals("aimedBow"))
                    {
                        InsnList toAdd = new InsnList();

                        toAdd.add(new VarInsnNode(Opcodes.ALOAD, 0));
                        toAdd.add(new VarInsnNode(Opcodes.ALOAD, 7));
                        toAdd.add(new VarInsnNode(Opcodes.FLOAD, 3));
                        toAdd.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "micdoodle8/mods/crossbowmod/client/ClientProxy", "bipedRotationHook", "(L" + this.nodemap.get("modelBipedClass") + ";L" + this.nodemap.get("entityClass") + ";F)V"));

                        methodnode.instructions.insertBefore(methodnode.instructions.get(count - 1), toAdd);
                        injectionCount++;
                        break label4123;
                    }
                }
            }
        }

        final ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        node.accept(writer);
        bytes = writer.toByteArray();

        System.out.println("Crossbow Mod 2 successfully injected bytecode into: " + node.name + " (" + injectionCount + " / " + operationCount + ")");

        return bytes;
    }
}
