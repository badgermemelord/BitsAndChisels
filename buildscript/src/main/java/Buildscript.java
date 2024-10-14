import io.github.coolcrabs.brachyura.dependency.JavaJarDependency;
import io.github.coolcrabs.brachyura.fabric.FabricLoader;
import io.github.coolcrabs.brachyura.fabric.FabricMaven;
import io.github.coolcrabs.brachyura.fabric.FabricProject;
import io.github.coolcrabs.brachyura.fabric.Yarn;
import io.github.coolcrabs.brachyura.maven.Maven;
import io.github.coolcrabs.brachyura.maven.MavenId;
import io.github.coolcrabs.brachyura.minecraft.Minecraft;
import io.github.coolcrabs.brachyura.minecraft.VersionMeta;
import net.fabricmc.mappingio.tree.MappingTree;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Buildscript extends FabricProject {

    @Override
    public VersionMeta createMcVersion() {
        return Minecraft.getVersion("1.18.2");
    }

    @Override
    public int getJavaVersion() {
        return 17;
    }

    @Override
    public MappingTree createMappings() {
        return Yarn.ofMaven(FabricMaven.URL, FabricMaven.yarn("1.18.2+build.4")).tree;
    }

    @Override
    public FabricLoader getLoader() {
        return new FabricLoader(FabricMaven.URL, FabricMaven.loader("0.15.11"));
    }

    @Override
    public void getModDependencies(ModDependencyCollector d) {
        // Libraries
        String[][] fapiModules = new String[][] {
            {"fabric-registry-sync-v0", "0.9.12+bb2e047760"},
            {"fabric-resource-loader-v0", "0.5.3+047a5ecb60"},
            {"fabric-renderer-api-v1", "0.5.0+bf48649860"},
            {"fabric-item-groups-v0", "0.3.16+91896a4960"},
            {"fabric-object-builder-api-v1", "2.1.5+032c981d60"},
            {"fabric-rendering-v1", "1.11.0+b7f3cf3460"},
            {"fabric-networking-api-v1", "1.0.24+2d30af4b60"},
            {"fabric-api-base", "0.4.5+64b7c69360"},
            {"fabric-models-v0", "0.3.7+d7c144a860"},
            {"fabric-renderer-indigo", "0.6.1+03e2b68760"},
            {"fabric-entity-events-v1", "1.4.9+d7c144a860"},
            {"fabric-events-interaction-v0", "0.4.20+d7c144a860"},
            {"fabric-rendering-data-attachment-v1", "0.3.9+ee3621fc60"},
            {"fabric-mining-level-api-v1", "2.1.6+cc71601c60"}
        };
        for (String[] module : fapiModules) {
            d.addMaven(FabricMaven.URL, new MavenId(FabricMaven.GROUP_ID + ".fabric-api", module[0], module[1]), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
        }
        //d.addMaven("https://storage.googleapis.com/devan-maven/", new MavenId("net.devtech:Stacc:1.2.3"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE, ModDependencyFlag.JIJ);
        //d.add("C://Users//paolo//Documents//GitHub//Stacc//build//libs", new MavenId("net.devtech:Stacc:1.2.3"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE, ModDependencyFlag.JIJ);
/*        d.add(new JavaJarDependency(Paths.get("C://Users//paolo//Documents//GitHub//Stacc//build//libs"), Paths.get("C://Users//paolo//Documents//GitHub//Stacc//build//libs"),
                new MavenId("net.devtech:Stacc:1.3.2")), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE, ModDependencyFlag.JIJ);*/
        d.add(new JavaJarDependency(Paths.get("C:\\Users\\paolo\\Documents\\GitHub\\Stacc\\build\\libs\\stacc-1.3.4.jar"), Paths.get("C:\\Users\\paolo\\Documents\\GitHub\\Stacc\\build\\libs\\stacc-1.3.4-sources.jar"),
                new MavenId("net.devtech:Stacc:1.3.4")), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE, ModDependencyFlag.JIJ);

        // Compat
        d.addMaven("https://maven.shedaniel.me/", new MavenId("me.shedaniel:RoughlyEnoughItems-api-fabric:6.0.247-alpha"), ModDependencyFlag.COMPILE);
        d.addMaven("https://maven.vram.io", new MavenId("io.vram:frex-fabric-mc118:6.0.236"), ModDependencyFlag.COMPILE);
        // Compat but for bruh moments
        d.addMaven("https://oskarstrom.net/maven", new MavenId("net.oskarstrom:DashLoader:2.0"), ModDependencyFlag.COMPILE);
        d.add(new JavaJarDependency(Maven.getMavenFileDep("https://gitlab.com/api/v4/projects/21830712/packages/maven", new MavenId("io.github.flemmli97", "flan", "1.18-1.6.6"), "-fabric-api.jar").file, null, null), ModDependencyFlag.COMPILE);
        d.addMaven("https://api.modrinth.com/maven", new MavenId("maven.modrinth", "goml-reserved", "1.5.0-beta.4+1.18.2"), ModDependencyFlag.COMPILE);
    }
}
