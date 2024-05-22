package fr.silenthill99.test_mod.data.tags;

import fr.silenthill99.test_mod.Main;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {
    public ModPoiTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> p_256617_,
                                  @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, p_256617_, Main.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new ResourceLocation(Main.MODID, "sound_poi"));
    }
}
