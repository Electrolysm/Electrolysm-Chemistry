package chemistry.electrolysm.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBunsenBurner extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Tube;
    ModelRenderer Stand1;
    ModelRenderer Stand2;
    ModelRenderer TestTube;
    ModelRenderer Shape1;
  
  public ModelBunsenBurner()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 8, 1, 8);
      Base.setRotationPoint(-4F, 23F, -4F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Tube = new ModelRenderer(this, 40, 0);
      Tube.addBox(0F, 0F, 0F, 2, 10, 2);
      Tube.setRotationPoint(-1F, 13F, -1F);
      Tube.setTextureSize(64, 32);
      Tube.mirror = true;
      setRotation(Tube, 0F, 0F, 0F);
      Stand1 = new ModelRenderer(this, 50, 0);
      Stand1.addBox(0F, 0F, 0F, 1, 26, 1);
      Stand1.setRotationPoint(5F, -2F, -0.5F);
      Stand1.setTextureSize(64, 32);
      Stand1.mirror = true;
      setRotation(Stand1, 0F, 0F, 0F);
      Stand2 = new ModelRenderer(this, 6, 28);
      Stand2.addBox(0F, 0F, 0F, 8, 1, 1);
      Stand2.setRotationPoint(0F, 2F, 0.25F);
      Stand2.setTextureSize(64, 32);
      Stand2.mirror = true;
      setRotation(Stand2, 0F, 0F, 0F);
      TestTube = new ModelRenderer(this, 23, 13);
      TestTube.addBox(0F, 0F, 0F, 2, 10, 2);
      TestTube.setRotationPoint(-1F, -2F, -1F);
      TestTube.setTextureSize(64, 32);
      TestTube.mirror = true;
      setRotation(TestTube, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 10);
      Shape1.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape1.setRotationPoint(-0.5F, -3F, -0.5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Tube.render(f5);
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

    public void renderStand(float scale){
        Stand1.render(scale);
        Stand2.render(scale);
    }

    public void renderTestTube(float scale){
        TestTube.render(scale);
        Shape1.render(scale);
    }
}
