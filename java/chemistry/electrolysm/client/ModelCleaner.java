package chemistry.electrolysm.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCleaner extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Side0;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Side3;
    ModelRenderer liquid;
  
  public ModelCleaner()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 2, 16);
      Base.setRotationPoint(-8F, 22F, -8F);
      Base.setTextureSize(256, 256);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Side0 = new ModelRenderer(this, 0, 26);
      Side0.addBox(0F, 0F, 0F, 16, 9, 2);
      Side0.setRotationPoint(-8F, 13F, 6F);
      Side0.setTextureSize(256, 256);
      Side0.mirror = true;
      setRotation(Side0, 0F, 0F, 0F);
      Side1 = new ModelRenderer(this, 0, 45);
      Side1.addBox(0F, 0F, 0F, 16, 9, 2);
      Side1.setRotationPoint(-8F, 13F, -8F);
      Side1.setTextureSize(256, 256);
      Side1.mirror = true;
      setRotation(Side1, 0F, 0F, 0F);
      Side2 = new ModelRenderer(this, 0, 62);
      Side2.addBox(0F, 0F, 0F, 2, 9, 12);
      Side2.setRotationPoint(6F, 13F, -6F);
      Side2.setTextureSize(256, 256);
      Side2.mirror = true;
      setRotation(Side2, 0F, 0F, 0F);
      Side3 = new ModelRenderer(this, 45, 22);
      Side3.addBox(0F, 0F, 0F, 2, 9, 12);
      Side3.setRotationPoint(-8F, 13F, -6F);
      Side3.setTextureSize(256, 256);
      Side3.mirror = true;
      setRotation(Side3, 0F, 0F, 0F);
      liquid = new ModelRenderer(this, 38, 63);
      liquid.addBox(0F, 0F, 0F, 12, 1, 12);
      liquid.setRotationPoint(-6F, 17F, -6F);
      liquid.setTextureSize(256, 256);
      liquid.mirror = true;
      setRotation(liquid, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Side0.render(f5);
    Side1.render(f5);
    Side2.render(f5);
    Side3.render(f5);
  }

    public void renderLiquid(float scale){
        liquid.render(scale);
    }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}